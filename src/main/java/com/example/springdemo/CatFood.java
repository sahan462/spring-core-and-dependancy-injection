package com.example.springdemo;

public class CatFood implements Food{
    @Override
    public void eat() {
        System.out.println("Eating cat foods");
    }
}
