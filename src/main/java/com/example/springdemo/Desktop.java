package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    @Override
    public void compile() {
        System.out.println("Compile using Desktop");
    }
}
