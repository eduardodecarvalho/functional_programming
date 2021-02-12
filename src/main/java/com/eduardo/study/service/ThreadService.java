package com.eduardo.study.service;

import org.springframework.stereotype.Service;

@Service
public class ThreadService {

	public static void factorial(Long num) {
		Long fat = 1L;

		for (Long i = 2L; i <= num; i++) {
			fat *= i;
		}
	}
}
