package com.bridgelabz.greetingapplication.controller;

import com.bridgelabz.greetingapplication.model.Greeting;
import com.bridgelabz.greetingapplication.model.User;
import com.bridgelabz.greetingapplication.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s";
    private static AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @GetMapping("/getGreeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(String.format(template, name));
    }

    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting) {
        return new Greeting(String.format(template, greeting.getContent()));
    }

    @PutMapping("/putMapping/{counter}")
    public Greeting sayHello(@PathVariable long counter, @RequestParam(value = "content") String content) {
        return new Greeting(String.format(template, content));
    }

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<String>(greetingService.getMessage(), HttpStatus.OK);
    }

    @GetMapping("/getGreetingMessage")
    public ResponseEntity<String> getGreetingMessage(@RequestParam(value = "firstName", defaultValue = "World") String firstName, @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return new ResponseEntity<String>(greetingService.getGreetingMessage(firstName, lastName), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> getGreeting(@RequestBody User user) {
        return new ResponseEntity<String>(greetingService.postMessage(user), HttpStatus.OK);
    }

    @PostMapping("/saveGreeting")
    public ResponseEntity<Greeting> saveGreeting(@RequestBody Greeting greeting) {
        return new ResponseEntity<Greeting>(greetingService.saveMessage(greeting), HttpStatus.OK);
    }
}