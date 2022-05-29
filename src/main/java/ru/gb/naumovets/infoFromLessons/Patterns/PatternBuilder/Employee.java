package ru.gb.naumovets.infoFromLessons.Patterns.PatternBuilder;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final String middleName;
//    private final String gender;

    //Не сможем вызвать приватный конструктор из другого класса
    private Employee(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
    }

    public static class Builder{

        private String firstName;
        private String lastName;
        private String middleName;

        public Builder(){

        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder middleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public Employee build(){
            return  new Employee(this);
        }
    }
}
