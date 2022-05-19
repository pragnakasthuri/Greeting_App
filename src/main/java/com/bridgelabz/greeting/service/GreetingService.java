package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting getGreetingById(long id) {
        return null; //greetingRepository.findById().get();
    }

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(TEMPLATE, (user.toString().isEmpty() ? "Hello World" : user.toString()));
        return null; //greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting greetUser(User user) {
        String message = String.format(TEMPLATE, (user.toString().isEmpty() ? "Hello World" : user.toString()));
        return new Greeting(counter.incrementAndGet(), message);
    }
}
