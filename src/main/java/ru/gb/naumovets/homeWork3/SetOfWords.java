package ru.gb.naumovets.homeWork3;

import java.util.*;

public class SetOfWords {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays
                .asList("Один",
                        "Два",
                        "Три",
                        "Четыре",
                        "Пять",
                        "Шесть",
                        "Семь",
                        "Восемь",
                        "Девять",
                        "Десять",
                        "Один",
                        "Два",
                        "Два",
                        "Два",
                        "Три"));
        //Массив с первоначальным набором слов
        System.out.println(arr);
        //Массив уникальных слов
        getUniqueValue(arr);
    }

    //Метод выводит список уникальных значений и считает количество повторений элементов переданного массива
    public static void getUniqueValue(ArrayList<String> arr){
        //Получаем уникальные значения из переданного массива
        HashSet<String> uArr = new HashSet<>(arr);
        System.out.println(uArr + "\n");
        //Считаем количество повторений элементов переданного массива
        HashMap<String,Integer> countEntry = new HashMap<>();
        for (String word : arr) {
            if(!countEntry.containsKey(word)){
                countEntry.put(word, 1);
            } else {
                countEntry.put(word, countEntry.get(word) + 1);
            }
        }
        for (Map.Entry<String, Integer> mapElement : countEntry.entrySet()) {
            System.out.println("Слово " + mapElement.getKey() + " встретилось: " + mapElement.getValue() + " раз(а)");
        }
    }
}
