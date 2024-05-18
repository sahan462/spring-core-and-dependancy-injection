package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //this annotation is used to say that the spring should be responsible hence it can use dependancy injection to create objects
public class Alien {


    //Autowiring in Spring simplifies dependency injection by automatically wiring together components,
    // reducing manual configuration and promoting loose coupling, thus enhancing productivity and maintainability
    // of the application.
    //simply this says that alien class needs to check for the container for laptop class object, because it can not access
    //container directly like in main class.
    @Autowired
    @Qualifier("laptop")
    Computer computer;

    public void code(){
        System.out.println("I am alien");
        computer.compile();
    }

}

//Dependency Injection: When Spring initializes the Alien bean, it will look for a bean of type Laptop in the application context.
//        Bean Creation: If a bean of type Laptop is found in the context, Spring will inject it into the laptop field of the Alien bean.
//        Automatic Wiring: Spring will wire the laptop field with the Laptop bean, ensuring that the Alien bean has access to a fully initialized
//        Laptop instance.
//        Lifecycle Management: Spring will manage the lifecycle of the Laptop bean, handling tasks such as initialization, scoping (if applicable), and destruction.
//        Optional Dependency: If no bean of type Laptop is found in the context, Spring will throw an exception (typically NoSuchBeanDefinitionException),
//        indicating that it couldn't satisfy the @Autowired dependency. However, if the Laptop field is marked as @Autowired(required = false),
//        Spring will not throw an exception and will leave the field uninitialized if no matching bean is found.
//        Overall, by using @Autowired, you delegate the responsibility of finding and injecting dependencies to the Spring IoC container, allowing for automatic wiring
//        and reducing the need for manual bean lookup and instantiation.
