package ru.gb.naumovets.homeWork2;

public class MyArray {
    /*
        Метод принимает на вход двумерный массив и возвращает сумму элементов этого массива. Если размер массива
        не 4Х4 или в массив переданы данные не типа int, выбрасывается соответствующее исключение.
    */
    public static void DoubleArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException();
                }
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(sum);
    }

}

/*

    Предыдущая версия решения:

    Метод принимает на вход двумерный массив и возвращает сумму элементов этого массива
    public static void DoubleArray(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        checkArrSize(arr);
        int sum = 0;
        int rowNumber = 0;
        for (String[] row : arr) {
            wrongCells(row, rowNumber);
            rowNumber ++;
            for (String column : row) {
                sum += Integer.parseInt(column);
            }
        }
        System.out.println(sum);
    }

    Метод проверяет тип данных внутри массива на корректность(int - корректно)
    public static void wrongCells(String[] arr, int rowNumber) throws MyArrayDataException{
        int columnNumber = 0;
        for (String index : arr) {
            try{
                Integer.parseInt(arr[columnNumber]);
                columnNumber++;
            } catch (NumberFormatException e){
                throw new MyArrayDataException(rowNumber, columnNumber);
            }
        }
    }

    Метод проверяет размер массива на корректность(4х4 - корректно)
    public static void checkArrSize(String[][] arr) throws MyArraySizeException{
        for (int i = 0; i < arr.length; i++) {
            if(arr.length != 4){
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i].length !=4){
                    throw new MyArraySizeException();
                }
            }
        }
 */