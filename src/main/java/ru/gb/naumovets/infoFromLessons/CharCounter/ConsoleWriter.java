package ru.gb.naumovets.infoFromLessons.CharCounter;

public class ConsoleWriter implements Writer {
    public void writer(String text) {
        System.out.println(text);
    }
}
