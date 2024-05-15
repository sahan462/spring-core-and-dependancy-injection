package com.example.springdemo;

import org.springframework.context.ApplicationContext; // Correct import statement
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringDemoApplication {

    public static void main(String[] args) {
        // Load annotation-based configuration
        ApplicationContext annotationContext = SpringApplication.run(SpringDemoApplication.class, args);

        //----------------- Get bean from annotation-based configuration---------------------
        Alien obj_1 = (Alien) annotationContext.getBean("alien");
        obj_1.code();

        // Load XML configuration
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");

        // -------------Get bean from XML configuration--------------------
        Human obj_2 = (Human) xmlContext.getBean("human"); //here you have to specify the id which is defined in xml file
        obj_2.work();


        //******************************Important****************************//

        /*
        * In spring if you want multiple object of the same class, it depends on the scope
        * which is you defined on that class in the xml file
        *
        * basically there are two scopes
        * 1 - Singleton
        * 2 - Prototype
        *
        * Singleton Scope:
        * If you define multiple beans with the same ID and the scope of the bean is singleton (which is the default scope in Spring),
        * Spring will only create one instance of the bean, regardless of how many times it's defined in the configuration.
        * Subsequent definitions of the bean with the same ID will override the previous ones, but Spring will still only
        * create and manage one instance of the bean.
        *
        * <bean id="human" class="com.example.springdemo.Human" scope="singleton">
           </bean>

        * Prototype Scope:
        * If you explicitly set the scope of the bean to prototype, each time the bean is requested from
        * the Spring container, a new instance of the bean will be created. In this case, defining multiple beans with the
        * same ID will result in multiple instances being created, each independent of the others.
        *
        * <bean id="human" class="com.example.springdemo.Human" scope="prototype">
           </bean>

        * */

    }

}


//beans are objects which are handled by spring framework

//The IoC (Inversion of Control) container is a core component of the Spring Framework responsible for managing the
//lifecycle of objects (beans) and controlling the flow of an application's execution.


//XML Configuration Context:

    //ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");

    //Here, you are creating an ApplicationContext using XML configuration specified in the spring.xml file.
    // This file typically defines beans and their dependencies using XML syntax. When you load the XML configuration
    // in this way, Spring creates and manages beans based on the definitions provided in the XML file.

//Annotation-based Configuration Context:

    //ApplicationContext annotationContext = SpringApplication.run(SpringDemoApplication.class, args);

    //This line starts up the Spring application context using annotation-based configuration. Spring Boot scans the
    //components in your application package and its sub-packages for annotations such as
    //@Component, @Service, @Repository, etc., and automatically registers them as Spring beans. This context is created based
    //on annotations like @SpringBootApplication, which enables component scanning.