package com.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.business.entities.Orders;
import com.business.entities.User;
import com.business.repositories.OrderRepository;

@Service
public class OrderServices {

	private final OrderRepository orderRepository;

	public OrderServices(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	// Get all orders
	public List<Orders> getOrders() {
		return this.orderRepository.findAll();
	}

	// Save order
	public void saveOrder(Orders order) {
		this.orderRepository.save(order);
	}

	// Update order
	public void updateOrder(int id, Orders order) {
		order.setoId(id);
		this.orderRepository.save(order);
	}

	// Delete order
	public void deleteOrder(int id) {
		this.orderRepository.deleteById(id);
	}

	// Get order history of a user
	public List<Orders> getOrdersForUser(User user) {
		return this.orderRepository.findOrdersByUser(user);
	}
}
