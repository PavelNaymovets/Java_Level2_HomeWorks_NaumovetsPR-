package ru.gb.naumovets.infoFromLessons.InnerClasses;

public class OuterMain {
    public static void main(String[] args) {
        //Non-static Inner класс
        Outer.Inner inner = new Outer().new Inner();
        //Static Inner класс. Не вызывается конструктор внешнего класса. Не создается экземпляр внешнего класса.
        Outer.SInner sInner = new Outer.SInner();
        //Можно получить доступ к статическому полю вложенного статического класса без создания объекта. К обычным полям нет.
        Outer.SInner.si = 1;
        sInner.i = 10;
    }
}
