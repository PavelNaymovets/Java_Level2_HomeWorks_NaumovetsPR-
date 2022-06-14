package ru.gb.naumovets.infoFromLessons.Collections;

import java.util.*;
import java.util.stream.Collectors;

public class Collectionses {
    public static void main(String[] args) {
        //Строка слов
        String[] words = "Один два три четыре пять шесть семь Восемь ДЕВЯТЬ десять один два два два три  ".toLowerCase().split("[\\p{Space}\\p{Punct}]+");
        List<String> wordList = Arrays.asList(words);
        Set<String> uniqueWords = new HashSet<>(wordList);
        //Посчитаем количество вхождений каждого слова в массик несколькими способами
        System.out.println("Первый способ");
        for (String word : uniqueWords) {
            //Подсчитывает количество вхождений слов в коллекцию
            int count = Collections.frequency(wordList, word);
            System.out.println("Слово: " + word + " встретилось " + count);
        }

        System.out.println("\nВторой способ");
        Map<String, Integer> map = new HashMap<>((int) (wordList.size() * 1.25));
        for (String s : wordList) {
            int count;
            if (!map.containsKey(s)) {
                count = 1;
            } else {
                count = map.get(s) + 1;
            }
            map.put(s, count);
        }
        map.forEach((k, v) -> System.out.println("Слово: " + k + " встретилось " + v));

        System.out.println("\nТретий способ");
        for (String s : wordList) {
            int count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);
        }
        map.forEach((k, v) -> System.out.println("Слово: " + k + " встретилось " + v));

        System.out.println("\nЧетвертый способ");
        for (String s : wordList) {
            //Если ключа s нет в мапе, то положится в мапу единица по ключу s. Если есть, то a значение в мапе и b это 1. Они сложатся и положаться в мапу по ключу s.
            map.merge(s, 1, (a, b) -> a + b);
        }
        map.forEach((k, v) -> System.out.println("Слово: " + k + " встретилось " + v));

        System.out.println("\nПятый способ");
        for (String s : wordList) {
            // Тоже, что и в 4 способе, только метод референс. Более короткая запись.
            map.merge(s, 1, Integer::sum);
        }
        map.forEach((k, v) -> System.out.println("Слово: " + k + " встретилось " + v));

        //Стримы
        System.out.println("\nШестой способ");
        Map<String,Long> collect = wordList.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        collect.forEach((k, v) -> System.out.println("Слово: " + k + " встретилось " + v));

    }
}
