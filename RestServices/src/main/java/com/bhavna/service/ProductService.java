package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.model.Product;
import com.bhavna.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;

	public List<Product> getALL() {
		return productRepo.findAll();
	}

}
