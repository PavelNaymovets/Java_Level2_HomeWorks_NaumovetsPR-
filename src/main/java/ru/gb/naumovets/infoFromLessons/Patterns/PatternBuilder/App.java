package ru.gb.naumovets.infoFromLessons.Patterns.PatternBuilder;

public class App {
    public static void main(String[] args) {
        //Позволяет инициализировать финальные поля внешнего класса не создавая множество конструкторов. Устанавливается
        //только то значение полей, что нас интересует. Если есть два конструктора с разными String полями, то конструктор создать
        //нельзя, так как java не понимает какой конструктор вызвать.
        Employee builder = new Employee.Builder()
                .lastName("Иванов")
                .firstName("Иван")
                .middleName("Иванович")
                .build();

        //Employee.Builder builder = new Employee.Builder();

        //builder.lastName("Иванов");
        //builder.firstName("Иван");
        //builder.middleName("Иванович");


    }
}
