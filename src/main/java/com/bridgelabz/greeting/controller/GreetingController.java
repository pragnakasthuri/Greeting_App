package com.bridgelabz.greeting.controller;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/{id}")
    public Greeting greetUser(@PathVariable(value="id") Long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/")
    public List<Greeting> getGreetings() {
        return greetingService.getGreetings();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteGreeting(@PathVariable(value="id") Long id) {
        return greetingService.deleteGreeting(id);
    }

    @PostMapping("/")
    public Greeting createGreeting(@RequestBody User user) {
        return greetingService.addGreeting(user);
    }

    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable(value="id") Long id, @RequestBody User user) {
        return greetingService.updateGreeting(id, user);
    }
}
