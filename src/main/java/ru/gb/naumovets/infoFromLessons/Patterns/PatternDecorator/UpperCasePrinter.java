package ru.gb.naumovets.infoFromLessons.Patterns.PatternDecorator;

import java.util.Locale;

public class UpperCasePrinter implements Printer {
    private Printer printer;

    public UpperCasePrinter(Printer printer){
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        printer.print(text.toUpperCase());
    }
}
