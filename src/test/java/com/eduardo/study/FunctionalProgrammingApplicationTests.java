package com.eduardo.study;

import com.eduardo.study.model.Product;
import com.eduardo.study.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FunctionalProgrammingApplicationTests {

	@Autowired
	private ProductService productService;

	@Test
	void orderProductsByName() {
		List<Product> products = productService.populateList();

		products.sort((p1, p2) -> p1.getName().toUpperCase()
				.compareTo(p2.getName().toUpperCase()));

		assertEquals("Camera", products.get(0).getName());
	}

	@Test
	void checkPairs() {
//		Challenge from HackerRank.:  It must return an integer representing the number of matching pairs

		final List<Integer> list = Arrays.asList(1, 6, 4, 3, 7, 8, 6, 5, 1, 1, 3, 4, 5);

		final Map<Object, Long> verifyDuplicatedList = list.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
		final long result = verifyDuplicatedList.values().stream().mapToLong(v -> v / 2).sum();
		assertEquals(5, result);
	}


	@Test
	void removeIf() {
		List<Product> products = productService.populateList();

		products.removeIf(p -> p.getPrice() >= 1500);

		assertEquals(2, products.size());

	}

	@Test
	void forEach() {
		List<Product> products = productService.populateList();

		products.stream().forEach(p -> p.setPrice(p.getPrice() * 1.1));

		assertEquals(1100.00, products.get(0).getPrice());

		Double totalPrice = products.stream().mapToDouble(p -> p.getPrice()).sum();

		assertEquals(11715.000000000002, totalPrice);

		products.stream().forEach(p -> p.setName(p.getName().toUpperCase()));

		assertEquals(products.get(1).getName(), "MOUSE");
	}

	@Test
	void map() {
		List<Product> products = productService.populateList();

		List<String> names = products.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

		List<String> expected = Arrays.asList("TV", "MOUSE", "COMPUTER", "CAMERA", "NOTEBOOK", "CELLPHONE");

		assertEquals(expected, names);
	}

	@Test
	void fibonacciSequence() {
		Stream<Integer> s = Stream.iterate(new Integer[]{0, 1},
				p -> new Integer[]{p[1], p[0] + p[1]}).map(p -> p[0]);

		String fibonacciSequence = "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]";

		assertEquals(fibonacciSequence, Arrays.toString(s.limit(10).toArray()));
	}

	@Test
	void twoSum() {
		// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
		// You may assume that each input would have exactly one solution, and you may not use the same element twice.
		// You can return the answer in any order.
		int[] nums = {1, 3, 5, 7};
		int target = 12;
		List<Integer> actual = new ArrayList();

		Map<Integer, Integer> map = new HashMap();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				actual.add(map.get(complement));
				actual.add(i);
				break;
			}
			map.put(nums[i], i);
		}

		List<Integer> expected = new ArrayList<Integer>() {
			{
				add(2);
				add(3);
			}
		};

		assertTrue(actual.containsAll(expected));
	}

}

