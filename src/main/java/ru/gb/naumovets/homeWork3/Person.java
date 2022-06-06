package ru.gb.naumovets.homeWork3;

import java.util.Objects;

public class Person {
    private String surname;
    private String number;

    public Person(String surname, String number) {
        this.surname = surname;
        this.number = number;
    }

    public String getSurname(){
        return surname;
    }

    public String getNumber(){
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return surname.equals(person.surname) && number.equals(person.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, number);
    }
}
