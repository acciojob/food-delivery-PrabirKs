package com.driver.ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.driver.io.Converter.FoodConverter;
import com.driver.io.Converter.UserConverter;
import com.driver.model.request.FoodDetailsRequestModel;
import com.driver.model.response.*;
import com.driver.service.FoodService;
import com.driver.shared.dto.FoodDto;
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
@RequestMapping("/foods")
public class FoodController {

	@Autowired
	FoodService foodService ;
	@GetMapping(path="/{id}")
	public FoodDetailsResponse getFood(@PathVariable String id) throws Exception{
		FoodDto foodDto=foodService.getFoodById(id);
		return FoodConverter.DtoToResponse(foodDto);
	}

	@PostMapping("/create")
	public FoodDetailsResponse createFood(@RequestBody FoodDetailsRequestModel foodDetails) throws Exception {
		FoodDto foodDto= FoodConverter.RequestToDto(foodDetails);
		foodDto= foodService.createFood(foodDto);
		return FoodConverter.DtoToResponse(foodDto);
	}

	@PutMapping(path="/{id}")
	public FoodDetailsResponse updateFood(@PathVariable String id, @RequestBody FoodDetailsRequestModel foodDetails) throws Exception{
		FoodDto foodDto = FoodConverter.RequestToDto(foodDetails);
		FoodDto foodDto1 = foodService.updateFoodDetails(id,foodDto);
		FoodDetailsResponse foodDetailsResponse = FoodConverter.dtoToResponse(foodDto1);
		return foodDetailsResponse;
	}

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteFood(@PathVariable String id) throws Exception{
		foodService.deleteFoodItem(id);
		OperationStatusModel operationStatusModel = OperationStatusModel.builder()
				.operationName(RequestOperationName.DELETE.toString())
				.operationResult(String.valueOf(RequestOperationStatus.SUCCESS))
				.build();
		return operationStatusModel;

	}
	
	@GetMapping()
	public List<FoodDetailsResponse> getFoods() {

		List<FoodDto> foodDtoList = foodService.getFoods();
		List<FoodDetailsResponse> foodDetailsResponseList = new ArrayList<>();
		for(FoodDto foodDto : foodDtoList)
		{
			FoodDetailsResponse foodDetailsResponse = FoodConverter.dtoToResponse(foodDto);
			foodDetailsResponseList.add(foodDetailsResponse);
		}
		return foodDetailsResponseList;

	}
}
