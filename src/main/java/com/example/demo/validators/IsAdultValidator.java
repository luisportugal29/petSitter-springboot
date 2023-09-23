package com.example.demo.validators;

import java.time.LocalDate;
import java.time.Period;

import com.example.demo.annotations.IsAdult;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsAdultValidator implements ConstraintValidator<IsAdult, LocalDate> {

    @Override
    public void initialize(IsAdult constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        if ( birthDate == null) 
            return false;
        
        LocalDate currentDate = LocalDate.now();
        Period gap = Period.between(birthDate, currentDate);

        return gap.getYears() >= 18;
    }
    
}
