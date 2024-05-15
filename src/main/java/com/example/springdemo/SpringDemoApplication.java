package com.example.springdemo;

import org.springframework.context.ApplicationContext; // Correct import statement
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringDemoApplication {

    public static void main(String[] args) {

        //beans are objects which are handled by spring framework
        //The IoC (Inversion of Control) container is a core component of the Spring Framework responsible for managing the
        //lifecycle of objects (beans) and controlling the flow of an application's execution.


        //******************* Load annotation-based configuration*************************
        ApplicationContext annotationContext = SpringApplication.run(SpringDemoApplication.class, args);

        /*
        * Annotation-based Configuration Context:

            ApplicationContext annotationContext = SpringApplication.run(SpringDemoApplication.class, args);

            This line starts up the Spring application context using annotation-based configuration. Spring Boot scans the
            components in your application package and its sub-packages for annotations such as
            @Component, @Service, @Repository, etc., and automatically registers them as Spring beans. This context is created based
            on annotations like @SpringBootApplication, which enables component scanning.

        */


        //Get bean from annotation-based configuration
        Alien obj_1 = (Alien) annotationContext.getBean("alien");
        obj_1.code();

        //*********************Load XML configuration***********************************
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");

        /*
        * XML Configuration Context:

            ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");

            Here, you are creating an ApplicationContext using XML configuration specified in the spring.xml file.
            This file typically defines beans and their dependencies using XML syntax. When you load the XML configuration
            in this way, Spring creates and manages beans based on the definitions provided in the XML file.

        */

        //Get bean from XML configuration
        Human obj_2 = (Human) xmlContext.getBean("human_1"); //here you have to specify the id which is defined in xml file
        obj_2.work();


        //******************************Important****************************//

        /*
        * In spring if you want multiple object of the same class,
        *
        * 1) It can be depended on the scope which is you defined on that class in the xml file

            * basically there are two scopes
            * 1 - Singleton (default)
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
        *
        *
        * 2) Alternatively, you can define multiple beans with different IDs to create multiple instances, like this:
        *
            * <bean id="human1" class="com.example.springdemo.Human"></bean>
            *<bean id="human2" class="com.example.springdemo.Human"></bean>
        *
        * */

        Human obj_3 = (Human) xmlContext.getBean("human_1");//here you have to specify the id which is defined in xml file
        obj_3.work();

        //here obj_2 and obj_3 are referred to one object

        Human obj_4 = (Human) xmlContext.getBean("human_2");//here you have to specify the id which is defined in xml file
        obj_4.work();

        Human obj_5 = (Human) xmlContext.getBean("human_2");//here you have to specify the id which is defined in xml file
        obj_5.work();

        //here obj_4 and obj_5 are referred to two different objects since the scope defined is xml file is prototype

        Human obj_6 = (Human) xmlContext.getBean("human_3");//here you have to specify the id which is defined in xml file
        obj_6.work();

        Human obj_7 = (Human) xmlContext.getBean("human_4");//here you have to specify the id which is defined in xml file
        obj_7.work();

        //here obj_6 and obj_7 are referred to two different objects since the ids are different

        //----------------------------Setter Injection-----------------------------------------



    }


}
