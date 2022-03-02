package com.bhavna.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.model.Category;
import com.bhavna.model.Orders;
import com.bhavna.myException.ErrorMsg;
import com.bhavna.repository.OrderRepository;
import com.bhavna.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	ProductRepository pRepository;

	@Autowired
	private OrderRepository oRepository;

	Category category = new Category();

	public List<Orders> getAllOrders() {
		return oRepository.findAll();
	}

	public String addOrder(Orders order) {
		Integer price = pRepository.getById(order.getProduct().getProductId()).getPrice();
		if ((order.getQuantity() <= 0)) {
			throw new ErrorMsg();
		} else {
			order.setOrderPrice(order.getQuantity() * price);
			oRepository.save(order);
			return "added successfully";
		}
	}

	public Orders getOrderById(Integer id) {
		return oRepository.findById(id).get();
	}

	public void deleteOrder(Integer id) {
		if (oRepository.existsById(id)) {
			oRepository.deleteById(id);
		} else {
			throw new NoSuchElementException();
		}
	}

	public Orders updateOrder(Integer order_id, Orders orders) {
		if (oRepository.existsById(order_id)) {
			Integer price = pRepository.getById(orders.getProduct().getProductId()).getPrice();
			if ((orders.getQuantity() <= 0)) {
				throw new ErrorMsg();
			} else {
				orders.setOrderPrice(orders.getQuantity() * price);
				return oRepository.save(orders);
			}

		} else {
			throw new NoSuchElementException();
		}
	}

	public Orders patchOrder(Integer id, Integer productId, Integer quantity) {
		Orders order = oRepository.findById(id).get();
		if (quantity != null)
			order.setQuantity(quantity);
		if (productId != null)
			order.setProduct(pRepository.findById(productId).get());
		Integer price = pRepository.getById(order.getProduct().getProductId()).getPrice();
		order.setOrderPrice(order.getQuantity() * price);
		System.out.println(order);
		return oRepository.save(order);
	}

}
