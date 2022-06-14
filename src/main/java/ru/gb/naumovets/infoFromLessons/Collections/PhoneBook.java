package ru.gb.naumovets.infoFromLessons.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    //Решение задачи с телефонным справочником с получением и добавлением нового значения номеров по имени за константное время
    private Map<String, List<String>> phones = new HashMap<>();

    void add(String name, String phone){
        List<String> phoneList = phones.getOrDefault(name, new ArrayList<>());
        phoneList.add(phone);
        //Каждый раз перезаписываем список номеров в мапе phones, когда добавляем новый номер к существующему имени(ключу)
        //так как не создан отдельный класс в котором можно было бы переопределить методы .equals() и
        phones.put(name, phoneList);
    }

    List<String> get(String name){
        return phones.getOrDefault(name, List.of());
    }
}
