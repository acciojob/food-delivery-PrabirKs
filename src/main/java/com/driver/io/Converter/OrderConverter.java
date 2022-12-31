package com.driver.io.Converter;

import com.driver.io.entity.OrderEntity;
import com.driver.shared.dto.OrderDto;

public class OrderConverter {
    public static OrderDto entityToDto(OrderEntity orderEntity)
    {
        OrderDto orderDto = OrderDto.builder()
                .id(orderEntity.getId())
                .status(orderEntity.isStatus())
                .items(orderEntity.getItems())
                .cost(orderEntity.getCost())
                .userId(orderEntity.getUserId())
                .orderId(orderEntity.getOrderId())
                .build();
        return orderDto;
    }
}
