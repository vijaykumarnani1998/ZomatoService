package com.zomato.user.controller;

import com.zomato.user.dto.UserDto;
import com.zomato.user.entity.UserEntity;
import com.zomato.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserEntity> createOrder(@RequestBody UserDto userDto){
        UserEntity user1 = userService.createUser(userDto);
        return  new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        UserEntity user1 = userService.getUserById(id);
        return  new ResponseEntity<>(user1, HttpStatus.OK);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
       List<UserEntity>  list = userService.getAllUsers();
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        String s = userService.deleteUserById(id);
        return  new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserEntity> updateOrder(@PathVariable Long userId,@RequestBody UserDto userDto){
        UserEntity user1 = userService.updateUserById(userId,userDto);
        return  new ResponseEntity<>(user1, HttpStatus.OK);
    }

}
