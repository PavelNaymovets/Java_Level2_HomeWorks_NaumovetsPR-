package ru.gb.naumovets.infoFromLessons.Patterns.PatternDecorator;

public class ConsolePrinter implements Printer{
    public void print(String text){
        System.out.print(text);
    }
}
