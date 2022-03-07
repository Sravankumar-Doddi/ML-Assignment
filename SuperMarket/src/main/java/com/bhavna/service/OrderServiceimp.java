package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.dao.OrdersDao;
import com.bhavna.model.Orders;

@Service
@Transactional
public class OrderServiceimp implements OrderService{

	@Autowired
	OrdersDao ordersDao;

	@Override
	public List<Orders> getOrders() {
		return ordersDao.getOrders();
	}

	@Override
	public String saveOrders(Orders orders) {
		ordersDao.saveOrders(orders);
		return "Order added successfully"+orders.getOrderId();
	}

	@Override
	public Orders getOrder(Integer oId) {
		return ordersDao.getOrderById(oId);
	}
	
	@Override
	public String updateOrder(Integer oId, Orders orders) {
		ordersDao.updateOrderById(oId, orders);
		return "Orders details updated successfully :"+orders.getOrderId();
	}
	
}
