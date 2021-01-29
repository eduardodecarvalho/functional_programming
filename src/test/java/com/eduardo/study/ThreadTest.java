package com.eduardo.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduardo.study.model.ThreadExtendsThread;
import com.eduardo.study.model.ThreadImplementsRunnable;

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
}
