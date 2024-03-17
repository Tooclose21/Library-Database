package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.entity.User;
import com.example.technologiesieciowe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody User addUser(@RequestBody User user){

        return userRepository.save(user);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
