package ru.gb.naumovets.infoFromLessons.multiThreading;

public class Volat {
    //У каждого потока есть своя память. Чтобы поток не кэшировал(хранил у себя в памяти) переменную, нужно использовать
    //ключевое слово volatile.
    volatile int i;

    void m(){
        i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        Volat volat = new Volat();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                volat.m();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                volat.m();
            }
        }).start();
    }
}
