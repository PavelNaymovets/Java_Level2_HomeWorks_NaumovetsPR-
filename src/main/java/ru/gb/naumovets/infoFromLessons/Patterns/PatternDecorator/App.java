package ru.gb.naumovets.infoFromLessons.Patterns.PatternDecorator;

public class App {
    public static void main(String[] args) {
        Printer consolePrinter = new ConsolePrinter();
        Printer borderPrinter = new BorderPrinter(consolePrinter);
//        Printer upperCasePrinter = new UpperCasePrinter(borderPrinter);
        Printer sparsePrinter1 = new SparsePrinter(borderPrinter);
        Printer sparsePrinter2 = new SparsePrinter(sparsePrinter1);
        PerformancePrinter performancePrinter = new PerformancePrinter(sparsePrinter2);
        performancePrinter.print("Hello World");

    }
}
