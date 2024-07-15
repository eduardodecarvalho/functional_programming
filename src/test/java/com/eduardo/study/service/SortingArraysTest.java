package com.eduardo.study.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortingArraysTest {

  @ParameterizedTest
  @MethodSource("getLists")
  void testMergeSorting(int[] list) {
    SortingArrays.mergeSorting(list);
    assertAll(() -> assertEquals(1, list[0]),
        () -> assertEquals(2, list[1]),
        () -> assertEquals(3, list[2]),
        () -> assertEquals(4, list[3]));
  }

  private static Stream<Arguments> getLists() {
    return Stream.of(Arguments.of(new int[] { 3, 4, 2, 1 }),
        Arguments.of(new int[] { 2, 1, 4, 3 }),
        Arguments.of(new int[] { 4, 3, 2, 1 }),
        Arguments.of(new int[] { 1, 4, 3, 2 }));
  }
}
