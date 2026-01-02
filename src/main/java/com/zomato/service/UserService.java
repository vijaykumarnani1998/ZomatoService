package com.zomato.service;

import com.zomato.dto.UserDto;
import com.zomato.entity.UserEntity;

import java.util.List;

public interface UserService {

    public UserEntity createUser(UserDto userDto);

    public UserEntity getUserById(Long userId);

    public List<UserEntity> getAllUsers();

    public String deleteUserById(Long userId);

    public UserEntity updateUserById(Long userId,UserDto userDto);

}
