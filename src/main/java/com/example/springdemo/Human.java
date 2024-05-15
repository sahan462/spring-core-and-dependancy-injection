package com.example.springdemo;

public class Human {

    private int age;
    private Laptop lap;

    public Human(){

    }

    public Human(int age, Laptop lap){
        this.age = age;
        this.lap = lap;
    }

    public void work(){
        System.out.println("I'm working");
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public Laptop getLap(){
        return this.lap;
    }
    public void setLap(Laptop lap) {
        this.lap = lap;
    }


}
