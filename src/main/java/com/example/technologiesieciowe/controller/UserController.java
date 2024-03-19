package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.UserDto;
import com.example.technologiesieciowe.dto.mappers.BookMapper;
import com.example.technologiesieciowe.dto.mappers.UserMapper;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.User;
import com.example.technologiesieciowe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserRepository userRepository;
    @Autowired

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody UserDto addUser(@RequestBody UserDto user){
        User entity = userRepository.save(UserMapper.fromDto(user));
        return UserMapper.toDto(entity);
        //return userRepository.save(user);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<UserDto> getAllUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).map(UserMapper::toDto).toList();
        //return userRepository.findAll();
    }
}
