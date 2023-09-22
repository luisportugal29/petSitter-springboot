package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
    List<User> findAll ();
}
