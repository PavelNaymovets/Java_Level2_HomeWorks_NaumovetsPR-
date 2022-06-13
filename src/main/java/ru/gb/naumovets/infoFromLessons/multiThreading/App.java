package ru.gb.naumovets.infoFromLessons.multiThreading;

import java.util.Arrays;

interface I {
    void m(int i, String s);
}

public class App {
    public static void main(String[] args) {
        //currentThread() - возвращает ссылку на объект текущего выполняющегося потока. Записываем ее в переменную.
        T t = new T();
        //Чтобы запустить поток, нужно вызвать метод start()
        t.start();
        Thread t1 = new Thread(new R());
        t1.start();
        Thread t2 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            thread.setName("MyRunnableThread");
            System.out.println("Привет из потока: " + Thread.currentThread().getName());
            System.out.println("R.getStackTrace() = " + Arrays.toString(Thread.currentThread().getStackTrace()));
        });
        t2.start();
        printThreadInfo();

        //Сколько процессоров (ядер) java машина имеет в своем распоряжении. availableProcessors() возвращает максимальное
        //количество процессоров (ядер), доступных виртуальной машине; никогда не меньше единицы. В процессе выполнения
        //количество доступных процессоров (ядер) может меняться
        System.out.println("Процессоры доступные для java машины " + Runtime.getRuntime().availableProcessors());

        //Небольшое упоминание о лямбда функции. Лямбда - анонимная функция. Простой способ написать реализацию матода анонимно(без имени).
        I helloworld = (a, b) -> System.out.println("Hello World");


        //Внутри каждого потока команды выполняются последовательно. Строка за строкой. Нет перепрыгиваний.
        //Планировщик задач решает какому потоку выделить процессорное время, поэтому выполнение потоков непоследовательное.
        System.out.println("Последовательность выполнения потоков");
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();
        MyThread thread5 = new MyThread();
        MyThread thread6 = new MyThread();
        MyThread thread7 = new MyThread();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        Thread[] thr = new Thread[20];
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new MyThread();
        }
        //устанавливаем приоиртет выполнениея потока. Не гарантирует, что поток будет вызван первом
        thr[5].setPriority(10);
        for (Thread thread : thr) {
            thread.start();
        }
    }

    private static void printThreadInfo() {
        Thread thread = Thread.currentThread();
        System.out.println("thread.getName() = " + thread.getName());
        System.out.println("thread.getStackTrace() = " + Arrays.toString(thread.getStackTrace()));
    }
}

//1-ый способ создания потока
class T extends Thread {
    //Чтобы создать поток, нужно переопределить метод run()
    @Override
    public void run() {
        System.out.println("Привет из потока: " + Thread.currentThread().getName());
        System.out.println("T.getStackTrace() = " + Arrays.toString(Thread.currentThread().getStackTrace()));
    }
}

//2-ый способ создания потока
class R implements Runnable {

    @Override
    public void run() {
        System.out.println("Привет из потока: " + Thread.currentThread().getName());
        System.out.println("R.getStackTrace() = " + Arrays.toString(Thread.currentThread().getStackTrace()));
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Привет из потока: " + Thread.currentThread().getName());
    }
}