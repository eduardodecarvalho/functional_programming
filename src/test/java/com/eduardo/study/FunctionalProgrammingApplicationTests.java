package com.eduardo.study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduardo.study.model.Product;
import com.eduardo.study.service.ProductService;

@SpringBootTest
class FunctionalProgrammingApplicationTests {

	@Autowired
	private ProductService productService;

	@Test
	void orderProductsByName() {
		List<Product> products = productService.populateList();

		products.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

		assertEquals("Camera", products.get(0).getName());
	}

	@Test
	void checkPairs() {
//		Challenge from HackerRank.:  It must return an integer representing the number of matching pairs

		final List<Integer> list = Arrays.asList(1, 6, 4, 3, 7, 8, 6, 5, 1, 1, 3, 4, 5);

		final Map<Object, Long> verifyDuplicatedList = list.stream()
				.collect(Collectors.groupingBy(k -> k, Collectors.counting()));
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
		Stream<Integer> s = Stream.iterate(new Integer[] { 0, 1 }, p -> new Integer[] { p[1], p[0] + p[1] })
				.map(p -> p[0]);

		String fibonacciSequence = "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]";

		assertEquals(fibonacciSequence, Arrays.toString(s.limit(10).toArray()));
	}

	@Test
	void testLetters() {
		String word = "Google";
		boolean result = false;

		if (word.equals(word.toUpperCase())) {
			result = true;
		}
		if (word.equals(word.toLowerCase())) {
			result = true;
		}
		String firstLetter = "" + word.charAt(0);
		if (firstLetter.equals(firstLetter.toUpperCase())) {
			String subWord = "";
			for (int j = 1; j < word.length(); j++) {
				subWord = subWord.concat("" + word.charAt(j));
				System.out.println(subWord);
			}
			if (subWord.equals(subWord.toLowerCase())) {
				result = true;
			}
		}
		assertTrue(result);
	}

	@Test
	void validateDouble() {
		Double valor1 = 12.565656d;
		String answer = String.format("%.2f", valor1 / 6.93);
		System.out.println("Formatando: " + answer);
		String answer2 = String.valueOf(valor1 / 6.93);
		System.out.println("Sem formatar: " + answer2);

	}

	@Test
	void functionalAndImperative() {
		List<Product> products = productService.populateList();

		System.out.println(" ---- IMPERATIVE ---- ");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}

		System.out.println(" ---- FUNCTIONAL ---- ");
		products.stream().forEach(product -> System.out.println(product));
		
	}
}
