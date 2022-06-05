package ru.gb.naumovets.homeWork2;

public class MyArraySizeException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Передан неверный размер массива. Предполагается 4х4.";

    public MyArraySizeException() {
        super(ERROR_MESSAGE);
    }

}
