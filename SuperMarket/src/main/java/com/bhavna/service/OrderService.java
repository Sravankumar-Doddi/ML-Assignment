package com.bhavna.service;

import java.util.List;

import com.bhavna.model.Orders;

public interface OrderService {
	
	public List<Orders> getOrders();
	
	public String saveOrders(Orders orders);
	
	public Orders getOrder(Integer oId);
	
	public String updateOrder(Integer oId, Orders orders);

}
