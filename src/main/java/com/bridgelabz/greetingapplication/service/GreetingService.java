package com.bridgelabz.greetingapplication.service;

import com.bridgelabz.greetingapplication.model.Greeting;
import com.bridgelabz.greetingapplication.model.User;
import com.bridgelabz.greetingapplication.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private static String template = "Hello %s";
    @Autowired
    GreetingAppRepository repository;

    public String getMessage() {
        return "Hello World";
    }

    public String getGreetingMessage(String firstName, String lastName) {
        return "Hello " + firstName + "" + lastName;
    }

    public String postMessage(User user) {
        return "Hello " + user.getfirstName() + "" + user.getlastName();
    }

    public Greeting saveMessage(Greeting greeting) {
        Greeting newGreeting = new Greeting(String.format(template, greeting.getContent()));
        repository.save(newGreeting);
        return newGreeting;
    }
}