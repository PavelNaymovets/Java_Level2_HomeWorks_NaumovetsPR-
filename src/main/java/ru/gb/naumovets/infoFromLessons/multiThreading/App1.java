package ru.gb.naumovets.infoFromLessons.multiThreading;

public class App1 {
    public static void main(String[] args) throws InterruptedException {
        MyThr thr = new MyThr();
        thr.start();
        thr.stop();

        MyThr thr1 = new MyThr();
        //Поток запустится не параллельно. В мэйн потоке просто вызовется метод run() у класса MyThr и последовательно,
        //как метод, исполнится.
//        thr1.run();
        //Программа не будет дожиться завершения выполнения демон потока, если все остальные не демон потоки завершили свою работу.
        thr1.setDaemon(true);
        System.out.println("Состояние потока " + thr1.getState());
        thr1.start();
        Thread.sleep(100);
        System.out.println("Состояние потока " + thr1.getState());
        //.join() остановит текущий поток и дождется пока поток thr1 выполнится и потом вернется к текущему потоку. Блокирующий метод
        //есть .join(100). Главный поток ждет пока выполнится сторонний 100 мс и затем идет далее
        thr1.join();
        //Повтроно один и тот же поток запустить нельзя
        //thr1.start();
        //Проверяем работает ли поток. Можно периодические поток опрашивать на предмет работы.
        System.out.println("Выполняется ли поток " + thr1.isAlive());
        //Позволяет получить состояние потка. Есть несколько состояний. Нужно провалиться в метод, чтобы их посмотреть.
        System.out.println("Состояние потока " + thr1.getState());
        System.out.println("Основной поток закончил работу ");
//        Thread.sleep(100);
//        thr1.interrupt();

        /*
        Способы прерывания потоков:

        1).stop(). Устаревший метод прерывания потока. Выполнение потока сразу прерывается, безусловно. Нет возможности корректно
        завершить работу и передать ресурсы
        Thread thr = new MyThr();
        thr.start();
        thr.stop();
        2).sleep().
        */

    }
}

class MyThr extends Thread{
    @Override
    public void run() {
        //isInterrupted() - возвращает false пока не вызван метод .interrupted() в другом потоке. Как только interrupt()
        //вызван, IsInterrupted() возвращает false. После того как InterruptedException вызван нужно самостоятельно вызывать
        //interrupt() в блоке catch(), чтобы прервать поток.
//        while(!isInterrupted()){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                interrupt();
//            }
//            System.out.println("Привет из потока: " + Thread.currentThread().getName());
//        }
        try {
            System.out.println("Поток начал работу: " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Поток закончил работу: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}