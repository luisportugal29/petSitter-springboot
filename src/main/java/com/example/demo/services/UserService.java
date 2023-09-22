package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dtos.UserDto;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto getUser(Integer id) {
        Optional<User> user = this.repository.findById(id);

        if (! user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }

        return this.modelMapper.map(user.get(), UserDto.class);
    }

    public List<UserDto> getUsers() {
         return this.repository
            .findAll()
            .stream()
            .map(user ->  {
                return this.modelMapper.map(user,  UserDto.class);
            })
            .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);

        return this.modelMapper.map(this.repository.save(user), UserDto.class);
    } 
    
}
