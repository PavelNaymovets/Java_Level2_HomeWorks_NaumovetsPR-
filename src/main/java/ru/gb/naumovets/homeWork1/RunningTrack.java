package ru.gb.naumovets.homeWork1;

public class RunningTrack implements Obstacle{
    //Длина беговой дорожки
    private int length;

    public RunningTrack(int length) {
        if(length < 0){
            System.out.println("Длина беговой дорожки не может быть меньше 0. Пожалуйста, укажите корректную длину");
        } else {
            this.length = length;
        }
    }

    public int getLength(){
        return length;
    }

}
