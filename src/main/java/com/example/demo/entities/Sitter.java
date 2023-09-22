package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SITTERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sitter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "lastname")
    private String lastName;

    private String description;

    @Column(name = "city_id")
    private Integer city;

    @Column(name = "debutyear")
    private LocalDate year;

}
