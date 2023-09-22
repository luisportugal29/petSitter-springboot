package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dtos.SitterDto;
import com.example.demo.entities.Sitter;
import com.example.demo.repositories.SitterRepositorie;

@Service
public class SitterService {

    @Autowired
    private SitterRepositorie repository;

    @Autowired
    private ModelMapper modelMapper;


    public SitterDto getSitter(Integer id) {
        Optional<Sitter> sitter = this.repository.findById(id);
        if (!sitter.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sitter not found");
        }
        
        return this.modelMapper.map(sitter.get(), SitterDto.class);
    }
    
    public List<SitterDto> getSitters() {
        return this.repository
            .findAll()
            .stream()
            .map(sitter ->  {
                return this.modelMapper.map(sitter,  SitterDto.class);
            })
            .collect(Collectors.toList());
    }

    public SitterDto createSitter(SitterDto sitterDto) {

        Sitter sitter = this.modelMapper.map(sitterDto, Sitter.class);

        return this.modelMapper.map(this.repository.save(sitter), SitterDto.class);

    }


}
