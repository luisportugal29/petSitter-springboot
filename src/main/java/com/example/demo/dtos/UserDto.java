package com.example.demo.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Integer id;

    @Size(max = 4, message = "Name must be at least 4 characters long")
    private String name;

    @Size(max = 10, message = "Lastname must be at least 10 characters long")
    private String lastName;

    @Size(max = 10, message = "address must be at least 10 characters long")
    private String address;

    @Email(message = "Invalid email")
    private String email;

    private String photo;

    @Size(min = 10, max = 10, message = "invalid phone number")
    private String phone;

    private LocalDate birthdate;

    @Size(min = 8, message = "password must be at least 8 characters long")
    private String password;

    private LocalDate createdAt;

}
