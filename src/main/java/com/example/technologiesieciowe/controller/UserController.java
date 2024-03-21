package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.UserDto;
import com.example.technologiesieciowe.dto.mappers.BookMapper;
import com.example.technologiesieciowe.dto.mappers.UserMapper;
import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.User;
import com.example.technologiesieciowe.filters.LoginForm;
import com.example.technologiesieciowe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    @Autowired

    public UserController(PasswordEncoder encoder, UserRepository userRepository){
        this.encoder = encoder;
        this.userRepository = userRepository;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody UserDto addUser(@RequestBody UserDto user){
        user.setPassword(encoder.encode(user.getPassword()));
        User entity = userRepository.save(UserMapper.fromDto(user));
        return UserMapper.toDto(entity);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<UserDto> getAllUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).map(UserMapper::toDto).toList();
    }
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody LoginForm loginForm){
        User user = userRepository.findByUsername(loginForm.getLogin());
        if (!encoder.matches(loginForm.getPassword(), user.getPassword())){
            return;
        }
        userRepository.delete(userRepository.findByUsername(loginForm.getLogin()));
    }
}
