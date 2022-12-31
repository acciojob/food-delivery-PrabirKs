package com.driver.ui.controller;

import java.util.List;

import com.driver.io.Converter.UserConverter;
import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.OperationStatusModel;
import com.driver.model.response.UserResponse;
import com.driver.service.UserService;
import com.driver.service.impl.UserServiceImpl;
import com.driver.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
	UserService userService ;
	@GetMapping(path = "/{id}")
	public UserResponse getUser(@PathVariable String id) throws Exception{

		UserDto userDto = userService.getUserByUserId(id);
		UserResponse userResponse = UserConverter.dtoToResponse(userDto);
		return userResponse;
	}

	@PostMapping()
	public UserResponse createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception{

		UserDto userDto= UserConverter.RequestToDto(userDetails);

		userDto=userService.createUser(userDto);
		return UserConverter.DtoToResponse(userDto);
	}

	@PutMapping(path = "/{id}")
	public UserResponse updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) throws Exception{

		return null;
	}

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteUser(@PathVariable String id) throws Exception{

		return null;
	}
	
	@GetMapping()
	public List<UserResponse> getUsers(){

		return null;
	}
	
}
