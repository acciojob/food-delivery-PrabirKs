package com.driver.service.impl;

import com.driver.io.Converter.OrderConverter;
import com.driver.io.entity.OrderEntity;
import com.driver.io.repository.OrderRepository;
import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository ;
    @Override
    public OrderDto createOrder(OrderDto order) {
        OrderEntity orderEntity = OrderConverter.dtoToEntity(order) ;
        orderEntity = orderRepository.save(orderEntity) ;
        return OrderConverter.entityToDto(orderEntity);
    }

    @Override
    public OrderDto getOrderById(String orderId) throws Exception {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId) ;

        return OrderConverter.entityToDto(orderEntity);
    }

    @Override
    public OrderDto updateOrderDetails(String orderId, OrderDto order) throws Exception {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId) ;
        orderEntity.setOrderId(order.getOrderId());
        orderEntity.setCost(order.getCost());
        orderEntity.setId(order.getId());
        orderEntity.setItems(order.getItems());
        orderEntity.setStatus(order.isStatus());
        orderEntity.setUserId(order.getUserId());

        orderEntity =orderRepository.save(orderEntity) ;
        return OrderConverter.entityToDto(orderEntity) ;
    }

    @Override
    public void deleteOrder(String orderId) throws Exception {
         orderRepository.deleteById(orderRepository.findByOrderId(orderId).getId());
    }

    @Override
    public List<OrderDto> getOrders() {
        List<OrderEntity> orderEntities = (List<OrderEntity>) orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>() ;

        for(OrderEntity order : orderEntities){
            OrderDto orderDto = OrderConverter.entityToDto(order) ;
            orderDtos.add(orderDto) ;
        }
        return orderDtos;
    }
}