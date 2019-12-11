package com.eduardo.study;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduardo.study.model.Product;

@SpringBootTest
class FunctionalProgrammingApplicationTests {

	@Test
	void orderProductsByName() {
		List<Product> products = new ArrayList<>();

		products.add(new Product(1, "       TV", 1000.00));
		products.add(new Product(2, "Mouse", 1500.00));
		products.add(new Product(3, "Computer", 2000.00));
		products.add(new Product(4, "   Camera", 1750.00));
		products.add(new Product(5, "Notebook", 3500.00));
		products.add(new Product(6, "Cellphone", 900.00));
		
		products.sort((p1, p2) -> p1.getName().toUpperCase()
				.compareTo(p2.getName().toUpperCase()));

		assertEquals("Camera", products.get(0).getName());
		
	}

}
