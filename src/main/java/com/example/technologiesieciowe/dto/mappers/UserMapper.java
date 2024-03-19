package com.example.technologiesieciowe.dto.mappers;

import com.example.technologiesieciowe.dto.entity.UserDto;
import com.example.technologiesieciowe.entity.User;

public class UserMapper {
    public static User fromDto(UserDto user){
        User userEntity = new User();
        userEntity.setEmail(user.getEmail());
        userEntity.setId(user.getId());
        userEntity.setRole(user.getRole());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.setFullUsername(user.getFullUsername());
        return userEntity;
    }
    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setRole(user.getRole());
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());
        userDto.setFullUsername(user.getFullUsername());
        return userDto;
    }
}
