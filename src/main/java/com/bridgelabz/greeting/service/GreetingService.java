package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(TEMPLATE, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting greetUser(User user) {
        String message = String.format(TEMPLATE, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return new Greeting(counter.incrementAndGet(), message);
    }

    @Override
    public List<Greeting> getGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Boolean deleteGreeting(long id) {
        greetingRepository.deleteById(id);
        return true;
    }

    @Override
    public Greeting updateGreeting(long id, User user) {
        Optional<Greeting> greetingObj = greetingRepository.findById(id);
        if (greetingObj.isPresent()) {
            Greeting greeting = greetingObj.get();
            String message = String.format(TEMPLATE, (user.toString().isEmpty()) ? "Hello World" : user.toString());
            greeting.setMessage(message);
            return greetingRepository.save(greeting);
        }
        return null;
    }
}
