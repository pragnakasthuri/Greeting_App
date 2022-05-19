package com.bridgelabz.greeting.repository;

import com.bridgelabz.greeting.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
