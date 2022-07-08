package com.palak.java;

public class FinalPlay {
    public static void main(String[] args) {


    }
}

class Animal {
    final String name;
    final String color;

    public Animal(String name) {
        this(name,""); //final instance variables must be initialized either on declaration
        //or in constructor.. If in constructor, then all the variant of constructor should init the final variable.
    }

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public final void play(){
        System.out.println(name + " playing");

        class Op{
            String o;
        }
        Op op = new Op();
    }

    //Possible to overload methods keeping either final or non-final. Doesn't matter.
    //what matters is overridding.
    public void play(String attr){
        System.out.println(name + " playing " + attr);
    }
}

class Tiger extends Animal {
    /*
    can't override final methods.
    @Override
    public void play() {
        super.play();
    }*/

    public Tiger(String name) {
        super(name);
    }
}