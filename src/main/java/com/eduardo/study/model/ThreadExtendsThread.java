package com.eduardo.study.model;

public class ThreadExtendsThread extends Thread {
	@Override
	public void run() {
		super.run();

		System.out.println(this.getName() + " thread");

		try {
			Thread.sleep(5000);
			System.out.println(this.getName() + " thread");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
