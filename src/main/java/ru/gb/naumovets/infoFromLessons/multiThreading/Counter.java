package ru.gb.naumovets.infoFromLessons.multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private final Object mutex1 = new Object(); // Ссылочный объект для mutex. Можно использовать любой ссылочный тип. Чаще всего применяют Object
    private final Object mutex2 = new Object(); // Ссылочный объект для mutex. Можно использовать любой ссылочный тип. Чаще всего применяют Object
    private AtomicInteger count = new AtomicInteger();
//    Можно синхронизировать приписав ключевое слово к сигнатуре метода. synchronized - значит, что пока 1 поток работатет
//    с переменной у дргугого потока нет доступа к этой переменной. В данном случае монитором выступает сам объект класса в котором синхронизированный метод
//    synchronized void increment(){ // read - increment - write
//        //race condition - состояние гонки. Потоки борятся за ресурс. В данном случае count переменную.
//        count++;
//    }

    //Можно синхронизировать используя synchronized блок
//    void increment() { // read - increment - write
//        //race condition - состояние гонки. Потоки борятся за ресурс. В данном случае count переменную.
//        synchronized (mutex) { // монитор или mutex - показатель занятости (флажок. Он не видим нам, но он есть в классе), в данном случае переменной. Принцип туалета.
//            count++;
//        }
//    }
//
//    void decrement() { // read - increment - write
//        //race condition - состояние гонки. Потоки борятся за ресурс. В данном случае count переменную.
//        synchronized (mutex) { // монитор или mutex - показатель занятости (флажок. Он не видим нам, но он есть в классе), в данном случае переменной. Принцип туалета.
//            count--;
//        }
//    }
    //Можно синхронизировать используя атомарные типы. Они быстрей синхронизиронизации. Выполняются за один шаг
    void increment() {
        count.incrementAndGet();
    }

    void decrement() {
        //.yield() - Указание планировщику переключиться на другой поток. Он может быть проигнорирован планировщиком.
        //Thread.yield();
        count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

}

class MyThreadIncrementor extends Thread {
    private final Counter counter;

    MyThreadIncrementor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            counter.increment();
        }
    }
}

class MyThreadDecrementor extends Thread {
    private final Counter counter;

    MyThreadDecrementor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            counter.decrement();
        }
    }
}

class App02 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThreadIncrementor t1 = new MyThreadIncrementor(counter);
        MyThreadDecrementor t2 = new MyThreadDecrementor(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("counter = " + counter.getCount());
    }
}
