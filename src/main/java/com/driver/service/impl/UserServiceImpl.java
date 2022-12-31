package com.driver.service.impl;

import com.driver.service.UserService;
import com.driver.shared.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Override
    public UserDto createUser(UserDto user) throws Exception {
        return null;
    }

    @Override
    public UserDto getUser(String email) throws Exception {
        return null;
    }

    @Override
    public UserDto getUserByUserId(String userId) throws Exception {
        return null;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) throws Exception {
        return null;
    }

    @Override
    public void deleteUser(String userId) throws Exception {

    }

    @Override
    public List<UserDto> getUsers() {
        return null;
    }
}