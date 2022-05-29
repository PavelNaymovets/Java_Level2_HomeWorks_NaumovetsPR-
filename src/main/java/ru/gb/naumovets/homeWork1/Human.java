package ru.gb.naumovets.homeWork1;

public class Human implements Participants{
    private final String name;
    private final int runLength;
    private final int jumpHeight;
    private boolean physicalCapacity = true;

    public Human(String name, int runLength, int jumpHeight){
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void jump(Wall obstacle) {
        if(obstacle.getHeight() <= jumpHeight){
            System.out.println(name + " смог перепрыгнуть стену");
        } else {
            System.out.println(name + " не смог перепрыгнуть стену высотой " + obstacle.getHeight() + " м");
            System.out.println(name + " выбывает из состязания");
            physicalCapacity = false;
        }
    }

    @Override
    public void run(RunningTrack obstacle) {
        if(obstacle.getLength() <= runLength){
            System.out.println(name + " смог пробежать беговую дорожку");
        } else {
            System.out.println(name + " не смог пробежать беговую дорожку длиной " + obstacle.getLength() + " м");
            System.out.println(name + " выбывает из состязания");
            physicalCapacity = false;
        }
    }

    @Override
    public boolean getPhysicalCapacity() {
        return physicalCapacity;
    }

}
