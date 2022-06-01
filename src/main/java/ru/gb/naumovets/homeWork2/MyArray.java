package ru.gb.naumovets.homeWork2;

public class MyArray {

    //Метод принимает на вход двумерный массив и возвращает сумму элементов этого массива
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

    //Метод проверяет тип данных внутри массива на корректность(int - корректно)
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

    //Метод проверяет размер массива на корректность(4х4 - корректно)
    public static void checkArrSize(String[][] arr) throws MyArraySizeException{
        if(arr.length != 4 || (arr.length != arr[0].length || arr.length != arr[1].length || arr.length != arr[2].length || arr.length != arr[3].length)){
            throw new MyArraySizeException();
        }
    }

}
