package com.driver.service.impl;

import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDto createOrder(OrderDto order) {
        return null;
    }

    @Override
    public OrderDto getOrderById(String orderId) throws Exception {
        return null;
    }

    @Override
    public OrderDto updateOrderDetails(String orderId, OrderDto order) throws Exception {
        return null;
    }

    @Override
    public void deleteOrder(String orderId) throws Exception {

    }

    @Override
    public List<OrderDto> getOrders() {
        return null;
    }
}