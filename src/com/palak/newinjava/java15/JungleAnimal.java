package com.palak.newinjava.java15;

public sealed interface JungleAnimal permits Monkey, Tiger{
}


final class Monkey implements JungleAnimal{

}

final class Tiger implements JungleAnimal{

}