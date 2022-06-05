package ru.gb.naumovets.homeWork2;

public class Main {
    public static void main(String[] args) {
        try {
            MyArray.doubleArray(new String[][]{
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"}});
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
