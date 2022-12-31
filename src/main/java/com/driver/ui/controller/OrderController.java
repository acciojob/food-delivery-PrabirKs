package com.driver.ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.driver.io.Converter.OrderConverter;
import com.driver.io.entity.OrderEntity;
import com.driver.io.repository.OrderRepository;
import com.driver.model.request.OrderDetailsRequestModel;
import com.driver.model.response.OperationStatusModel;
import com.driver.model.response.OrderDetailsResponse;
import com.driver.model.response.RequestOperationName;
import com.driver.model.response.RequestOperationStatus;
import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;
import org.aspectj.weaver.ast.Or;
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
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService ;
	@Autowired
	OrderRepository orderRepository;

	@GetMapping(path="/{id}")
	public OrderDetailsResponse getOrder(@PathVariable String id) throws Exception{
        OrderDto orderDto = orderService.getOrderById(id) ;
		OrderDetailsResponse orderDetailsResponse = OrderConverter.dtoToResponse(orderDto) ;
		return orderDetailsResponse;
	}
	
	@PostMapping()
	public OrderDetailsResponse createOrder(@RequestBody OrderDetailsRequestModel order) {
		OrderDto orderDto = OrderConverter.requestToDto(order) ;
		orderDto = orderService.createOrder(orderDto) ;

		return OrderConverter.dtoToResponse(orderDto);
	}
		
	@PutMapping(path="/{id}")
	public OrderDetailsResponse updateOrder(@PathVariable String id, @RequestBody OrderDetailsRequestModel order) throws Exception{
		OrderDto orderDto = OrderConverter.requestToDto(order);
		orderDto = orderService.updateOrderDetails(id,orderDto);
		OrderDetailsResponse orderDetailsResponse = OrderConverter.dtoToResponse(orderDto);
		return orderDetailsResponse;
	}
	
	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteOrder(@PathVariable String id) throws Exception {

		orderService.deleteOrder(id);

		OperationStatusModel operationStatusModel =  OperationStatusModel.builder()
				.operationName(RequestOperationName.DELETE.toString())
				.operationResult(RequestOperationStatus.SUCCESS.toString())
				.build() ;
		return operationStatusModel;
	}
	
	@GetMapping()
	public List<OrderDetailsResponse> getOrders() {
		List<OrderDetailsResponse> orderDetailsResponses = new ArrayList<>() ;
		List<OrderDto> orderDtos = orderService.getOrders() ;

		for(OrderDto orderDto : orderDtos ){
			OrderDetailsResponse orderDetailsResponse = OrderConverter.dtoToResponse(orderDto) ;
			orderDetailsResponses.add(orderDetailsResponse) ;
		}
		return orderDetailsResponses;
	}
}
