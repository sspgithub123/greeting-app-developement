package com.bridgelabz.greetingapplication.repository;

import com.bridgelabz.greetingapplication.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingAppRepository extends JpaRepository<Greeting, Integer> {
};