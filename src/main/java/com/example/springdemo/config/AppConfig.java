package com.example.springdemo.config;

import com.example.springdemo.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration //if you are using java based configuration you have to use this annotation

public class AppConfig {

    //if you want your spring framework to create the object you have to add bean annotation
    //if you do not specify the names the default name will be the method name
    @Bean(name = {"dog1", "zeeba", "teddy", "rexy"})

    //if you want to change the scope of the bean you have to use the @Scope annotation
    @Scope("prototype") //by default scope is singleton and here it is changed to prototype
    @Primary
    public Dog dog(){
        return new Dog();
    }

    @Bean(name = {"dog2", "primaryBeanTest"})
    public Dog primaryBeanTestDog(@Qualifier("dogFood") Food food){ //in this case you can use either @Qualifier or @Primary annotations
        Dog d = new Dog();
        d.setfood(food);
        return d;
    }

    @Bean
    @Primary
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public CatFood catFood(){
        return new CatFood();
    }

    @Bean
    public DogFood dogFood(){
        return new DogFood();
    }

}
