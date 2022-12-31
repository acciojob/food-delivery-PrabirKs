package com.driver.service.impl;

import com.driver.io.Converter.UserConverter;
import com.driver.io.entity.UserEntity;
import com.driver.io.repository.UserRepository;
import com.driver.service.UserService;
import com.driver.shared.dto.UserDto;
import com.driver.ui.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) throws Exception {
        UserEntity userEntity = UserConverter.dtoToEntity(user) ;
        userRepository.save(userEntity) ;
        return user;
    }

    @Override
    public UserDto getUser(String email) throws Exception {
        UserEntity userEntity=userRepository.findByEmail(email);

        return UserConverter.entityToDto(userEntity);
    }

    @Override
    public UserDto getUserByUserId(String userId) throws Exception {
        UserEntity userEntity = userRepository.findByUserId(userId) ;
        return UserConverter.entityToDto(userEntity) ;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) throws Exception {
        UserEntity userEntity = userRepository.findByUserId(userId);
        userEntity.setUserId(user.getUserId());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());

        userEntity =userRepository.save(userEntity) ;
        return UserConverter.entityToDto(userEntity) ;
    }

    @Override
    public void deleteUser(String userId) throws Exception {
       UserEntity user =  userRepository.findByUserId(userId) ;
       userRepository.deleteById(user.getId());
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>() ;

        for(UserEntity user : users){
            UserDto userDto = UserConverter.entityToDto(user) ;
            userDtos.add(userDto) ;
        }
        return userDtos;
    }
}