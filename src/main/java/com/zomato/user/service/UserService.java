package com.zomato.user.service;

import com.zomato.user.dto.UserDto;
import com.zomato.user.entity.UserEntity;

import java.util.List;

public interface UserService {

    public UserEntity createUser(UserDto userDto);

    public UserEntity getUserById(Long userId);

    public List<UserEntity> getAllUsers();

    public String deleteUserById(Long userId);

    public UserEntity updateUserById(Long userId,UserDto userDto);

}
