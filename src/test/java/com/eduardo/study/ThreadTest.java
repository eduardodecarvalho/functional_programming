package com.eduardo.study;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduardo.study.model.ThreadExtendsThread;
import com.eduardo.study.model.ThreadImplementsRunnable;
import com.eduardo.study.service.ThreadService;

@SpringBootTest
public class ThreadTest {

	@Test
	void workingWithThreads_extendsThread() {
		ThreadExtendsThread firstThread = new ThreadExtendsThread();
		ThreadExtendsThread secondeThread = new ThreadExtendsThread();

		firstThread.start();
		secondeThread.start();
	}

	@Test
	void workingWithThreads_implementsRunnable() {
		ThreadImplementsRunnable firstThread = new ThreadImplementsRunnable();
		ThreadImplementsRunnable secondeThread = new ThreadImplementsRunnable();

		firstThread.run();
		secondeThread.run();
	}

	@Test
	void forEachXParallel() {
		Long startForEach = System.currentTimeMillis();
		int firstNumber = 1;
		int lastNumber = 1000000;

		IntStream.range(firstNumber, lastNumber).forEach(num -> ThreadService.factorial(Long.valueOf(num)));
		Long endForEach = System.currentTimeMillis();
		System.out.println("Time: " + (endForEach - startForEach));

		Long startParallel = System.currentTimeMillis();
		IntStream.range(firstNumber, lastNumber).parallel().forEach(num -> ThreadService.factorial(Long.valueOf(num)));
		Long endParallel = System.currentTimeMillis();
		System.out.println("Time: " + (endParallel - startParallel));

	}
}
