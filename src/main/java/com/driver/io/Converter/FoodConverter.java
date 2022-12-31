package com.driver.io.Converter;

import com.driver.io.entity.FoodEntity;
import com.driver.model.request.FoodDetailsRequestModel;
import com.driver.model.response.FoodDetailsResponse;
import com.driver.shared.dto.FoodDto;

public class FoodConverter {
    public static FoodDto RequestToDto(FoodDetailsRequestModel food) {
        return FoodDto.builder()
                .foodName(food.getFoodName())
                .foodPrice(food.getFoodPrice())
                .foodCategory(food.getFoodCategory())
                .build();
    }

    public static FoodDetailsResponse DtoToResponse(FoodDto food) {
        return FoodDetailsResponse.builder()
                .foodId(food.getFoodId())
                .foodName(food.getFoodName())
                .foodPrice(food.getFoodPrice())
                .foodCategory(food.getFoodCategory())
                .build();
    }
    public static FoodDto EntityTODto(FoodEntity foodEntity){
        FoodDto foodDto = FoodDto.builder()
                .foodName(foodEntity.getFoodName())
                .foodPrice(foodEntity.getFoodPrice())
                .foodCategory(foodEntity.getFoodCategory())
                .build();
        return foodDto ;
    }

    public static FoodDetailsResponse dtoToResponse(FoodDto foodDto) {

        FoodDetailsResponse foodDetailsResponse = FoodDetailsResponse.builder()
                .foodId(foodDto.getFoodId())
                .foodName(foodDto.getFoodName())
                .foodPrice(foodDto.getFoodPrice())
                .foodCategory(foodDto.getFoodCategory())
                .build();
        return  foodDetailsResponse;
    }
}
