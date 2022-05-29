package ru.gb.naumovets.infoFromLessons.Patterns.PatternDecorator;

public class BorderPrinter implements Printer {
    private Printer printer;

    public BorderPrinter(Printer printer){
        this.printer = printer;
    }

    public void print(String text) {
        System.out.println("*".repeat(text.length() + 4));
        System.out.print("* ");
        printer.print(text);
        System.out.println(" *");
        System.out.println("*".repeat(text.length() + 4));
    }
}
