package com.example.springdemo;

import org.springframework.context.ApplicationContext; // Correct import statement
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);

//        Alien obj = new Alien();
//        obj.code();

        // Dependency injection

        //using annotations
        Alien obj_1 = context.getBean(Alien.class);
        obj_1.code();

        Alien obj_2 = (Alien) context.getBean("alien");
        obj_2.code();

        //using xml file



    }

}

//beans are objects which are handled by spring framework

//The IoC (Inversion of Control) container is a core component of the Spring Framework responsible for managing the
//lifecycle of objects (beans) and controlling the flow of an application's execution.
