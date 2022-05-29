package ru.gb.naumovets.infoFromLessons.Patterns.PatternDecorator;

public class SparsePrinter implements Printer {
    private Printer printer;

    public SparsePrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(String text) {
        StringBuilder stringBuilder = new StringBuilder(" ");
        for (char c : text.toCharArray()) {
            stringBuilder.append(c).append(" ");
        }
        printer.print(stringBuilder.toString());
    }
}
