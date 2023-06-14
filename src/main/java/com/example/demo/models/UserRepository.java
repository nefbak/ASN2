package com.example.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;

import io.micrometer.core.annotation.TimedSet;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByName(String name);

}
