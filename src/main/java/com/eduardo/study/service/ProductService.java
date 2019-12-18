package com.eduardo.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardo.study.model.Product;

@Service
public class ProductService {

	public List<Product> populateList(){
		List<Product> products = new ArrayList<>();

		products.add(new Product(1, "       TV", 1000.00));
		products.add(new Product(2, "Mouse", 1500.00));
		products.add(new Product(3, "Computer", 2000.00));
		products.add(new Product(4, "   Camera", 1750.00));
		products.add(new Product(5, "Notebook", 3500.00));
		products.add(new Product(6, "Cellphone", 900.00));
		
		return products;
	}
}
