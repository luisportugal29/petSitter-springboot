package com.example.demo.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String photo;
    private String phone;
    private LocalDate birthdate;
    private String password;
    private LocalDate createdAt;

}
