package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Sitter;

public interface SitterRepositorie extends CrudRepository<Sitter, Integer> {
    
    List<Sitter> findAll();

    Optional<Sitter> findById(Integer id);

    List<Sitter> findByName(String name);

    List<Sitter> findByNameStartsWithIgnoreCaseOrderByName(String name);

    boolean existsByNameAndLastName(String name, String lastName);
    
}
