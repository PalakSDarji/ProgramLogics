package com.palak.newinjava.java15;

public class SealedInterfaceEx {
    public static void main(String[] args) {
        JungleAnimal jungleAnimal = provideAnimal();

        if(jungleAnimal instanceof Monkey monkey){
            System.out.println("use monkey : " + monkey);
        }
        else if(jungleAnimal instanceof Tiger tiger){
            System.out.println("use tiger : " + tiger);
        }
    }

    private static JungleAnimal provideAnimal() {
        return new Monkey();
    }
}
