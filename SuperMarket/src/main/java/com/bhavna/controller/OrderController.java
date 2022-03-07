package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Orders;
import com.bhavna.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService oService;
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getMsg() {
		return "hello";
	}
	
	@GetMapping("/getAllOrders")
	@ResponseBody
	public List<Orders> getAllOrders(){
		return oService.getOrders();
	}
	
	@RequestMapping(value = "/getOrdersById/{oId}", method = RequestMethod.GET)
	public Orders getOrder(@PathVariable("oId") Integer oId) {
		return oService.getOrder(oId);
	}
	
	@RequestMapping(value = "/saveOrder",method = RequestMethod.POST)
	public String saveOrder(@RequestBody Orders orders) {
		return oService.saveOrders(orders);
	}
	
	@RequestMapping(value = "/updateOrder/{oId}", method = RequestMethod.PUT)
	public String updateOrder(@PathVariable("oId") Integer oId, @RequestBody Orders orders) {
		return oService.updateOrder(oId, orders);
	}
}
