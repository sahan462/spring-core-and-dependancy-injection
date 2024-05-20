package com.example.springdemo;

public class DogFood implements Food{

    @Override
    public void eat() {
        System.out.println("Eating dog foods");
    }

}
