package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.SitterDto;
import com.example.demo.services.SitterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sitters")
public class SitterController {

    @Autowired
    private SitterService sitterService;

    @GetMapping("/{id}")
    public SitterDto getSitter(@PathVariable Integer id) {
        return this.sitterService.getSitter(id);
    }

    @GetMapping
    public List<SitterDto> getSitters() {
        return this.sitterService.getSitters();
    }

    @GetMapping("/search")
    public List<SitterDto> searchSittersByName(
        @RequestParam String name) {
        return this.sitterService.searchSittersByName(name);
    }

    @PostMapping
    public SitterDto createSitter(@RequestBody @Valid SitterDto sitterDto) {
        return this.sitterService.createSitter(sitterDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSitter(@PathVariable Integer id) {
        this.sitterService.deleteSitter(id);
        return ResponseEntity.noContent().build();
    }

}
