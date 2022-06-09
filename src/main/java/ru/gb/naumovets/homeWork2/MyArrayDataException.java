package ru.gb.naumovets.homeWork2;

public class MyArrayDataException extends RuntimeException {

    private static final String ERROR_MESSAGE = "В ячейке лежит символ или текст вместо числа. Номер строки: %d, номер столбца: %d";

    public MyArrayDataException(int rowNumber, int columnNumber) {
        super(String.format(ERROR_MESSAGE, rowNumber, columnNumber));
    }

}
