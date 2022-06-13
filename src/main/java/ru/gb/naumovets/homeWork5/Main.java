package ru.gb.naumovets.homeWork5;

import java.util.Arrays;

public class Main {
    //Размер массива
    private static final int ARR_SIZE = 5_000_000;
    //Количество частей в массиве
    private static final int SNIPPET_COUNT = 8;
    //Размер части массива
    private static final int SNIPPET_ARR_SIZE = ARR_SIZE / SNIPPET_COUNT;

    public static void main(String[] args) {
        //Количество свободных процессоров (ядер), доступных виртуальной машине
        System.out.println("Количество свободных процессоров(ядер) = " + Runtime.getRuntime().availableProcessors());
        //Создаем массив для выполнения в однопоточной среде
        float[] arr = new float[ARR_SIZE];
        //Заполняем единицами
        Arrays.fill(arr, 1.0f);

        //Засекаем время начала выполнения программы
        long start1 = System.currentTimeMillis();
        meth1(arr, 0);
        long result1 = System.currentTimeMillis() - start1;
        System.out.println("Время работы метода в одном потоке = " + result1);

        //Создаем массив для выполнения в многопоточной среде. Создаю массив второй раз, чтобы массивы для однопоточной и
        //многопоточной среды на выходе содержали одинаковые значения.
        float[] arr2 = new float[ARR_SIZE];
        Arrays.fill(arr2, 1.0f);
        long start2 = System.currentTimeMillis();
        meth2(arr2, SNIPPET_COUNT);
        long result2 = System.currentTimeMillis() - start2;
        System.out.println("Время работы метода в нескольких потоках = " + result2);

        System.out.println("Отличие в скорости работы: " + ((double) result1 / result2));
    }

    public static void meth2(float[] arr, int snippetCount) {
        float[][] subArr = new float[snippetCount][SNIPPET_ARR_SIZE];
        //Потоки храним в массиве так, как мы должны с начала запустить все потоки и затем дождаться их завершения.
        Thread[] threads = new Thread[snippetCount];
        for (int i = 0; i < snippetCount; i++) {
            //Разобьем массив arr на части
            System.arraycopy(arr, i * SNIPPET_ARR_SIZE, subArr[i], 0, SNIPPET_ARR_SIZE);
            //Переменная, которая используется в лямбда выражении должна быть финальной. Для этого создаем переменную final j.
            final int j = i;
            threads[j] = new Thread(() -> meth1(subArr[j], j * SNIPPET_ARR_SIZE));
            threads[j].start();
        }

        //Для корректного подсчета времени нужно воспользоваться методом .join(). Он остановит выполнение остальных потоков
        //до тех пор, пока не выполнится тот на который он был вызван. Это нужно для корректного подсчета времени работы потока.
        for (int i = 0; i < snippetCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Склеим массив обратно
        for (int i = 0; i < snippetCount; i++) {
            System.arraycopy(subArr[i], 0, arr, i * SNIPPET_ARR_SIZE, SNIPPET_ARR_SIZE);
        }
    }

    public static void meth1(float[] arr, int offset) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
        }
    }
}
