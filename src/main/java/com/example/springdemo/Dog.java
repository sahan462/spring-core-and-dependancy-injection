package com.example.springdemo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

public class Dog {

    private Food iamdog;

    public void bark(){
        System.out.println("Dog is barking");
    }
}
