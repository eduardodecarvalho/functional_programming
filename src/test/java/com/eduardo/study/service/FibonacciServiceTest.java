package com.eduardo.study.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciServiceTest {

    HashMap<Integer, Integer> fibonacciCache = new HashMap<>();

    public int getFibonacciNumberByIndex(int index) {
        int fibo = 0;
        int actual = 1;
        int prev = 0;
        if (index == 0)
            return index;
        for (int i = 0; i < index; i++) {
            fibo = actual + prev;
            if (i == index - 2) {
                return fibo;
            }
            prev = actual;
            actual = fibo;
        }
        return fibo;
    }

    public int fibonacciRecursive(int index) {
        if (index <= 1) {
            return index;
        }
        if (fibonacciCache.containsKey(index)) {
            return fibonacciCache.get(index);
        }
        int fibonacci = fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2);
        fibonacciCache.put(index, fibonacci);
        return fibonacci;
    }

    public int fibonacciWithStream(int index) {
        index++;
        Stream<Integer> s = Stream.iterate(new Integer[] { 0, 1 },
                p -> new Integer[] { p[1], p[0] + p[1] }).map(p -> p[0]);
        return s.limit(index).reduce((first, second) -> second).orElse(0);
    }

    @ParameterizedTest
    @MethodSource()
    void testGetFibonacciNumberByIndex(Integer index, Integer value) {

        assertAll(
                () -> assertEquals(value, getFibonacciNumberByIndex(index)),
                () -> assertEquals(value, fibonacciRecursive(index)),
                () -> assertEquals(value, fibonacciWithStream(index)));
    }

    private static Stream<Arguments> testGetFibonacciNumberByIndex() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(9, 34),
                Arguments.of(12, 144),
                Arguments.of(20, 6765));
    }

}
