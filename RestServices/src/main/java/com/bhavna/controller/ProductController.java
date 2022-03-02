package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Product;
import com.bhavna.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService pService;

	@GetMapping("/getAll")
	public List<Product> getAllProducts() {
		return pService.getALL();
	}

}
