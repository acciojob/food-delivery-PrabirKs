package com.driver.io.Converter;


import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.UserResponse;
import com.driver.shared.dto.UserDto;

public class UserConverter {

    public static UserResponse dtoToResponse(UserDto userDto) {
        UserResponse userResponse = UserResponse.builder()
                .userId(userDto.getUserId())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build() ;
        return userResponse ;
    }

    public static UserDto RequestToDto(UserDetailsRequestModel userDetails) {
        UserDto userDto = UserDto.builder()
                .firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName())
                .email(userDetails.getEmail())
                .build();
        return userDto ;
    }

    public static UserResponse DtoToResponse(UserDto userDto) {
        UserResponse userResponse = UserResponse.builder()
                .userId(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
        return userResponse ;
    }
}
