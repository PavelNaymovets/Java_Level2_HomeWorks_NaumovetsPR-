package ru.gb.naumovets.homeWork1;

public class Main {
    public static void main(String[] args) {
        Participants[] participants = new Participants[]{
                new Cat("Мурзик", 5,5),
                new Human("Анатолий", 10,10),
                new Robot("Иван", 15,15)
        };

        Obstacle[] obstacles = new Obstacle[]{
                new Wall(5),
                new RunningTrack(5),
                new Wall(10),
                new RunningTrack(10),
                new Wall(15),
                new RunningTrack(20),
                new Wall(15),
                new RunningTrack(15),
        };

        for (Participants participant : participants) {
            for (Obstacle obstacle : obstacles) {
                participant.getOverObstacle(obstacle);
            }
        }
    }
}
