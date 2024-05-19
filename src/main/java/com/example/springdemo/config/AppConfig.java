package com.example.springdemo.config;

import com.example.springdemo.Cat;
import com.example.springdemo.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //if you are using java based configuration you have to use this annotation

public class AppConfig {

    //if you want your spring framework to create the object you have to add bean annotation
    //if you do not specify the names the default name will be the method name
    @Bean(name = {"dog", "zeeba", "teddy", "rexy"})

    //if you want to change the scope of the bean you have to use the @Scope annotation
    @Scope("prototype") //by default scope is singleton and here it is changed to prototype
    public Dog dog(){
        return new Dog();
    }

    @Bean(name = {"primaryBeanTest"})
    public Dog dog2(){
        return new Dog();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }

}
