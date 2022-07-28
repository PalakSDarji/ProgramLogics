package com.palak.newinjava.java14;

public class RecordEx {
    public static void main(String[] args) {
        Person p1 = new Person("Palak",1);
        Person p2 = new Person("Hiya",2);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.name());

        Human human1 = new NewPerson("Dhara",3);
        human1.live();
        System.out.println(human1);

        Human human2 = new NewPerson(4);
        human2.live();
        System.out.println(human2);

        System.out.println(p1.UNKNOWN_ADDRESS);
    }
}

//Creates immutable object with generated getters, final constructor, equals,
//hashcode, toString.
record Person(String name,int id){
    public static String UNKNOWN_ADDRESS = "Unknown"; //can contain static methods and variables
}

interface Human{
    void live();
}

record NewPerson(String name, int id) implements Human{

    public NewPerson(int id){
        this(null,id);
        System.out.println("inside sec constructor");
    }

     private void doLiving(){
         System.out.println("living..");
     }

    @Override
    public void live() {
         doLiving();
    }

    @Override
    public String toString() {
        return "NewPerson{" +
                "id=" + id +
                '}';
    }
}
