package ru.gb.naumovets.homeWork1;


public interface Participants {
    /*
    Метод getOverObstacle имеет дефолтную реализацию, чтобы избежать дублирование кода в классах
    имплементирующих интерфейс Participants (Cat, Human, Robot).

    В методе применено логическое сравнение типов объекта. Для этой цели используется метод .getClass() класса Object.
     */
    default void getOverObstacle(Obstacle obstacle){
        //Если участник имеет физическую возможность преодолеть препятствие, то он это сделает. Иначе - нет.
        if(getPhysicalCapacity()){
            if(obstacle.getClass() == Wall.class){
                jump((Wall) obstacle);
            } else if(obstacle.getClass() == RunningTrack.class){
                run((RunningTrack) obstacle);
            }
        }
    }
    void jump(Wall obstacle);
    void run(RunningTrack obstacle);
    boolean getPhysicalCapacity();
}
