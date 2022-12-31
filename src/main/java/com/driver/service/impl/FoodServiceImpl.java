package com.driver.service.impl;

import com.driver.io.Converter.FoodConverter;
import com.driver.io.entity.FoodEntity;
import com.driver.io.repository.FoodRepository;
import com.driver.service.FoodService;
import com.driver.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;
    @Override
    public FoodDto createFood(FoodDto food) throws Exception {

        FoodEntity foodEntity = FoodEntity.builder()
                .foodName(food.getFoodName())
                .foodId(food.getFoodId())
                .foodCategory(food.getFoodCategory())
                .foodPrice(food.getFoodPrice())
                .build();
        foodRepository.save(foodEntity);
        return getFoodById(food.getFoodId());
    }

    @Override
    public FoodDto getFoodById(String foodId) throws Exception {
        FoodEntity food = foodRepository.findByFoodId(foodId);
        if (food == null) {
            throw new Exception("Invalid FoodID");
        }
        return FoodConverter.EntityTODto(food);
    }

    @Override
    public FoodDto updateFoodDetails(String foodId, FoodDto foodDetails) throws Exception {
        long id = foodRepository.findByFoodId(foodId).getId();
        FoodEntity food = FoodEntity.builder()
                .id(id)
                .foodPrice(foodDetails.getFoodPrice())
                .foodId(foodId)
                .foodName(foodDetails.getFoodName())
                .foodCategory(foodDetails.getFoodCategory())
                .build();

        food = foodRepository.save(food);
        return FoodConverter.EntityTODto(food);
    }

    @Override
    public void deleteFoodItem(String id) throws Exception {
        FoodEntity foodEntity = foodRepository.findByFoodId(id);

        foodRepository.deleteById(foodEntity.getId());
    }

    @Override
    public List<FoodDto> getFoods() {
        List<FoodDto> foodDtos = new ArrayList<>();
        List<FoodEntity> foodEntities;
        foodEntities = (List<FoodEntity>) foodRepository.findAll();

        for (FoodEntity foodEntity : foodEntities) {
            FoodDto foodDto = FoodConverter.EntityTODto(foodEntity);
            foodDtos.add(foodDto);
        }
        return foodDtos;
    }

}