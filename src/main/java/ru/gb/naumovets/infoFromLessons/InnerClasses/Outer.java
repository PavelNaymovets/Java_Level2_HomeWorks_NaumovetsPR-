package ru.gb.naumovets.infoFromLessons.InnerClasses;

public class Outer {
    public int a = 10;
    public static int i = 10;

    void m(){

    }

    static void sm() {

    }

    public Inner getInner(){
        return new Inner();
    }

    public class Inner{
        void innerM(){
            a = 1;
            i = 42;
            m();
            sm();
        }
    }

    public static class SInner{
        public int i;
        public static int si;
        //Статический вложенный класс не может обращаться к обычным полям и методам внешнего класса
        void innerM(){
            //Если создать объект внешнего класса, то появится доступ к нестатическим полям и методам
            new Outer().a = 10;
            new Outer().m();
//            a = 1;
            i = 42;
//            m();
            sm();
        }
    }
}
