package com.example.demo.dtos;
import java.time.LocalDate;

import com.example.demo.annotations.IsAdult;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SitterDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @Size(min = 4, max = 100, message = "invalid name")
    private String name;

    @Size(min = 4, max = 100, message = "invalid lastName")
    private String lastName;

    private String description;

    @Min(1)
    private Integer city;

    @IsAdult
    private LocalDate year;
    
}
