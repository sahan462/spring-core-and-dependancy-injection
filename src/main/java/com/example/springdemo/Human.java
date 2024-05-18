package com.example.springdemo;

public class Human {

    private int age;
    private Computer asusLap;

    public Human(){

    }

    public Human(int age, Computer lap){
        this.age = age;
        this.asusLap = lap;
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
    public Computer getLap(){
        return this.asusLap;
    }
    public void setLap(Laptop lap) {
        this.asusLap = lap;
    }

    public void setAsusLap(Laptop asusLap) {
        this.asusLap = asusLap;
    }
}
