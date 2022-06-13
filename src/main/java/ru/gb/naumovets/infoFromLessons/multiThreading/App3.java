package ru.gb.naumovets.infoFromLessons.multiThreading;

public class App3 {
    private final Object mon = new Object();
    private int data = 0;

    //Поток должен дождаться пока данные будут подготовлены и только потом читать. Надо уступить место другому потоку.
    //Пока данные не подготовлены их другой поток не читает. Это не параллельная работа, а синхронизированная.
    // wait(), notify() - могут быть вызваны только внутри синхронизированного блока и только на объекте mutex. Если прервать
    //ожидание wait() - то вылетит interruptedException, также как и у метода .sleep(). .wait() и .notify() содержаться в класса Object.
    //.sleep() - не освобождает монитор, .wait() - освобождает монитор => методом в синхронизации можно пользоваться.
//    public void receive(){
//        synchronized (mon){
//            try {
//                mon.wait();
//                System.out.println("Data receive " + data);
//                mon.notifyAll();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    synchronized public void receive() {
        try {
            this.wait();
            System.out.println("Data receive " + data);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    public void prepare() {
//        synchronized (mon) {
//            try {
//                System.out.println("Data prepare " + (++data));
//                mon.notifyAll();
//                mon.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    synchronized public void prepare() {
        try {
            System.out.println("Data prepare " + (++data));
            this.notifyAll();
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        App3 app3 = new App3();
        Thread receiver = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                app3.receive();
            }
        });
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                app3.prepare();
            }
        });

        receiver.start();
        producer.start();

        try {
            receiver.join();
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
