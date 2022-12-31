package com.driver.io.Converter;

import com.driver.io.entity.OrderEntity;
import com.driver.model.request.OrderDetailsRequestModel;
import com.driver.model.response.OrderDetailsResponse;
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

    public static OrderDetailsResponse dtoToResponse(OrderDto orderDto) {
        OrderDetailsResponse orderDetailsResponse = OrderDetailsResponse.builder()
                .orderId(orderDto.getOrderId())
                .userId(orderDto.getUserId())
                .cost(orderDto.getCost())
                .items(orderDto.getItems())
                .status(orderDto.isStatus())
                .build() ;
        return orderDetailsResponse ;
    }

    public static OrderDto requestToDto(OrderDetailsRequestModel order) {
        OrderDto orderDto = OrderDto.builder()
                .userId(order.getUserId())
                .items(order.getItems())
                .cost(order.getCost())
                .userId(order.getUserId())
                .build() ;
        return orderDto ;

    }

    public static OrderEntity dtoToEntity(OrderDto orderDto) {
        return OrderEntity.builder()
                .cost(orderDto.getCost())
                .items(orderDto.getItems())
                .userId(orderDto.getUserId())
                .status(orderDto.isStatus())
                .orderId(orderDto.getOrderId())
                .build();
    }
}
