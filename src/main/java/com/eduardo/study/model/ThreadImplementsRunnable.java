package com.eduardo.study.model;

public class ThreadImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Implements Runnable");

		try {
			Thread.sleep(5000);
			System.out.println("Implements Runnable");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

