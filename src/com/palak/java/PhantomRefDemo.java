package com.palak.java;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Objects;

public class PhantomRefDemo {
    public static void main(String[] args) throws InterruptedException {

        Person person = new Person("Palak");
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Person> personPhantomReference = new PersonPhantomRef(person,referenceQueue);

        System.out.println("ref = "+ personPhantomReference);

        Thread.sleep(5000);

        System.out.println("Collecting garbage!");

        System.gc();
        Runtime.getRuntime().gc();

        Thread.sleep(300);

        System.out.println("ref = "+ personPhantomReference.get());

        //person = null;
        Thread.sleep(5000);

        System.out.println("Collecting garbage!");

        System.gc();
        Runtime.getRuntime().gc();
    }
}

class PersonPhantomRef extends PhantomReference<Person>{

    public PersonPhantomRef(Person referent, ReferenceQueue<Person> q) {
        super(referent, q);

        PersonClearingThread personClearingThread = new PersonClearingThread(q);
        personClearingThread.start();
    }

    void cleanUp(){
        System.out.println("Clearing PersonPhantomRef");
        clear();
    }
}

class PersonClearingThread extends Thread {

    ReferenceQueue<Person> queue;

    public PersonClearingThread(ReferenceQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        System.out.println("Started thread to look for Person object's clearing job.");

        Reference<? extends Person> ref;

        while(true){
            ref = queue.poll();
            System.out.println("queue: " + ref);
            if(ref != null){
                break;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ((PersonPhantomRef)ref).cleanUp();
    }
}

class Person{
    String name;
    private StringBuffer data;

    public Person(String name) {
        this.name = name;
        this.data = new StringBuffer();
        for (long i = 0; i < 500; i++) {
            this.data.append('x');
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Person finalize called");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && data.equals(person.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, data);
    }
}
