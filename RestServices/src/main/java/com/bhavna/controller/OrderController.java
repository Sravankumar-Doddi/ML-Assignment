package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Orders;
import com.bhavna.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService oService;

	@GetMapping(path = "/get")
	public String get() {
		return "Hello";
	}
	
	@GetMapping(path = "/getAllOrders")
	public List<Orders> getAllorders() {
		return oService.getAllOrders();
	}

	@PostMapping("/addOrder")
	public String addOrder(@RequestBody Orders order) {
		oService.addOrder(order);
		return "added successfully";
	}

	@GetMapping("/getOrder/{id}")
	public Orders getOrderById(@PathVariable("id") Integer id) {
		return oService.getOrderById(id);
	}

	@DeleteMapping("/deleteOrder/{id}")
	public String deleteOrderById(@PathVariable("id") Integer id) {
		oService.deleteOrder(id);
		return "deleted successfully";
	}

	@PutMapping("/updateOrder/{order_id}")
	public Orders updateByCategory(@PathVariable("order_id") Integer order_id, @RequestBody Orders order) {
		return oService.updateOrder(order_id, order);

	}

	@PatchMapping("/patch/{id}")
	public Orders patchOrder(@PathVariable("id") Integer id,
			@RequestParam(name = "item", required = false) Integer item_id,
			@RequestParam(name = "quantity", required = false) Integer quantity) {
		return oService.patchOrder(id, item_id, quantity);

	}

}
