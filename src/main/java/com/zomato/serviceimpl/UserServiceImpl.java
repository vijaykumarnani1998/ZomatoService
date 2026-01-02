package com.zomato.serviceimpl;

import com.zomato.config.ModelMapperConfig;
import com.zomato.dto.UserDto;
import com.zomato.entity.UserEntity;
import com.zomato.repository.UserRepository;
import com.zomato.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserEntity createUser(UserDto userDto) {

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(Long userId) {
     return userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not Found with"+ userId));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with" + userId));
            userRepository.deleteById(userEntity.getUserId());
            return  "User"+userId + "Successfully deleted ";

    }

    @Override
    public UserEntity updateUserById(Long userId,UserDto userDto) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with" + userId));
            modelMapper.map(userDto,userEntity);
        return userRepository.save(userEntity);

    }


}
