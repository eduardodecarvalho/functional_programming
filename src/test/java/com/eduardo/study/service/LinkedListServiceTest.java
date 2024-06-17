package com.eduardo.study.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduardo.study.model.datasctructures.linkedlist.LinkedListService;

@SpringBootTest
class LinkedListServiceTest {

    @Autowired
    private LinkedListService linkedListService;

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15, Integer.MAX_VALUE })
    void testAppendNode(int value) {
        var result = linkedListService.appendNode(value);

        assertAll(
                () -> assertEquals(1, result.getLenght()),
                () -> assertEquals(result.getHaed().getValue(), value),
                () -> assertEquals(result.getTail().getValue(), value));
    }
}
