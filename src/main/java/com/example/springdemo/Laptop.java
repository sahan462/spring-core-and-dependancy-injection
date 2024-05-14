package com.example.springdemo;

import elemental.json.impl.JsonUtil;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    public void compile(){
        System.out.println("Compiling");
    }


}
