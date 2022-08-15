package com.palak.java;

public class DefaultInterface {
}

interface Vehicle {
    void getSpeed();
    default void getAlarmOn(){
        System.out.println("turning alarm on");
    }
    default void getAlarmOff(){
        System.out.println("turning alarm off");
    }
}

interface Alarm {
    default void getAlarmOn(){
        System.out.println("turning alarm on");
    }
    default void getAlarmOff(){
        System.out.println("turning alarm off");
    }
}

class Bike implements Vehicle, Alarm {

    @Override
    public void getSpeed() {

    }

    @Override
    public void getAlarmOn() {
        Vehicle.super.getAlarmOn();
    }

    @Override
    public void getAlarmOff() {
        Vehicle.super.getAlarmOff();
    }
}