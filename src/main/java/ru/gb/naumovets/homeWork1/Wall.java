package ru.gb.naumovets.homeWork1;

public class Wall implements Obstacle{
    //Высота стены
    private int height;

    public Wall(int height) {
        if(height < 0){
            System.out.println("Высота стены не может быть меньше 0. Пожалуйста, укажите корректную высоту");
        } else {
            this.height = height;
        }
    }

    public int getHeight(){
        return height;
    }

}
