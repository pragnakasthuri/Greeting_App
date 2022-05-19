package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);

    Greeting greetUser(User user);

    List<Greeting> getGreetings();

    Boolean deleteGreeting(long id);

    Greeting updateGreeting(long id, User user);
}
