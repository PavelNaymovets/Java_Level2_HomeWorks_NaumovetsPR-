package ru.gb.naumovets.homeWork3;

import java.util.HashSet;

public class PhoneBook {
    private HashSet<Person> phoneBook;

    public PhoneBook(){
        phoneBook = new HashSet<>();
    }

    public void add(Person person){
        phoneBook.add(person);
    }

    public void get(String surname){
        for (Person person : phoneBook) {
            if(person.getSurname().equals(surname)){
                System.out.println(person.getNumber());
            }
        }
    }

}
