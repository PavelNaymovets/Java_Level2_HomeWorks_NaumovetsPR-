package ru.gb.naumovets.infoFromLessons.Collections;

import ru.gb.naumovets.homeWork3.Person;
import ru.gb.naumovets.homeWork3.PhoneBook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Создаю справочник
        PhoneBook phoneBook = new PhoneBook();
        //Наполняю справочник Фамилиями и номерами телефонов
        phoneBook.add(new Person("Васильев", "8(911)298-98-87"));
        phoneBook.add(new Person("Васильев", "8(911)298-10-87"));
        phoneBook.add(new Person("Васильев", "8(911)298-00-87"));
        phoneBook.add(new Person("Сидоров", "8(911)291-00-87"));
        phoneBook.add(new Person("Петров", "8(911)292-00-87"));
        phoneBook.add(new Person("Иванов", "8(911)310-01-53"));
        phoneBook.add(new Person("Иванов", "8(911)267-10-26"));
        phoneBook.add(new Person("Гуляев", "8(912)294-66-98"));
        //Получаю номера телефонов по фамилии
        phoneBook.get("Васильев");
    }
}
