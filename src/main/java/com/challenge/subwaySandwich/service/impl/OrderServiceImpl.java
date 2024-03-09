package com.challenge.subwaySandwich.service.impl;

import org.springframework.stereotype.Service;

import com.challenge.subwaySandwich.models.Order;
import com.challenge.subwaySandwich.repositories.OrderRespository;
import com.challenge.subwaySandwich.services.OrderService;
import com.challenge.subwaySandwich.services.base.impl.SimpleAbstractBaseServiceImpl;

@Service
public class OrderServiceImpl extends SimpleAbstractBaseServiceImpl<Order>
       implements OrderService {
	
	private OrderRespository orderRepository;

	public OrderServiceImpl(OrderRespository baseRepository) {
        super(baseRepository);
        this.repository = baseRepository;
        this.orderRepository = baseRepository;
    }

}
