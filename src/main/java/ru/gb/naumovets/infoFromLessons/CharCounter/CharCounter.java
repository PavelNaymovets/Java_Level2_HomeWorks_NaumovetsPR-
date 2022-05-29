package ru.gb.naumovets.infoFromLessons.CharCounter;

public class CharCounter {

    private final Reader reader;
    private final Writer writer;

    public CharCounter(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    //Подсчет количества вхождение символов в строку
    public void processText(){
        String text = reader.read();
        int [] c = new int[128];
        for (char c1 : text.toCharArray()) {
            c[c1]++;
        }
        for (char i = 0; i < c.length; i++) {
            if(c[i] != 0){
                writer.writer(i + " встретилось " + c[i] + " раз");
            }
        }
    }
}
