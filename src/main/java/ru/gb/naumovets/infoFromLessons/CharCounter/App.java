package ru.gb.naumovets.infoFromLessons.CharCounter;

public class App {
    public static void main(String[] args) {
        Reader reader = new FileReader("abc.text");
        Writer writer = new ConsoleWriter();

        CharCounter charCounter = new CharCounter(reader, writer);
        charCounter.processText();
    }
}
