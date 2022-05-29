package ru.gb.naumovets.infoFromLessons.Patterns.PatternDecorator;

public class PerformancePrinter implements Printer {
    private Printer printer;

    public PerformancePrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(String text) {
        long l = System.currentTimeMillis();
        printer.print(text);
        System.out.println(System.currentTimeMillis() - l);
    }

}
