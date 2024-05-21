package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.dto.entity.UserDto;
import com.example.technologiesieciowe.dto.mappers.UserMapper;
import com.example.technologiesieciowe.entity.User;
import com.example.technologiesieciowe.filters.LoginForm;
import com.example.technologiesieciowe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.StreamSupport;

/**
 * The type User controller.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/user")
public class UserController {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    /**
     * Instantiates a new User controller.
     *
     * @param encoder        the encoder
     * @param userRepository the user repository
     */
    @Autowired

    public UserController(PasswordEncoder encoder, UserRepository userRepository){
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    /**
     * Add user user dto.
     *
     * @param user the user
     * @return the user dto
     */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody UserDto addUser(@RequestBody UserDto user){
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            User entity = userRepository.save(UserMapper.fromDto(user));
            return UserMapper.toDto(entity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot add user");
        }
    }

    /**
     * Get all users iterable.
     *
     * @return the iterable
     */
    @GetMapping("/getAll")
    public @ResponseBody Iterable<UserDto> getAllUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).map(UserMapper::toDto).toList();
    }

    /**
     * Delete user.
     *
     * @param loginForm the login form
     */
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody LoginForm loginForm){
        try {
            User user = userRepository.findByUsername(loginForm.getUsername());
            if (!encoder.matches(loginForm.getPassword(), user.getPassword())){
                return;
            }
            userRepository.delete(userRepository.findByUsername(loginForm.getUsername()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot delete user");
        }
    }
}
