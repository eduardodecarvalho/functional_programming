package com.eduardo.study.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.eduardo.study.model.datasctructures.linkedlist.MyLinkedList;

class LinkedListServiceTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15, Integer.MAX_VALUE })
    void testAppendNode_emptyLinkedList(int value) {
        var myLinkedList = new MyLinkedList();
        myLinkedList.append(value);

        assertAll(
                () -> assertEquals(1, myLinkedList.getLenght()),
                () -> assertEquals(myLinkedList.getHead().getValue(), value),
                () -> assertEquals(myLinkedList.getTail().getValue(), value));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15 })
    void testAppendNode_notEmptyLinkedList(int value) {
        var myLinkedList = new MyLinkedList();
        myLinkedList.append(value);
        myLinkedList.append(value * 2);

        assertAll(
                () -> assertEquals(2, myLinkedList.getLenght()),
                () -> assertEquals(myLinkedList.getHead().getValue(), value),
                () -> assertEquals(myLinkedList.getTail().getNext().getValue(), value * 2));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15 })
    void testRemoveLastNode_emptyLinkedList(int value) {
        var myLinkedList = new MyLinkedList();
        myLinkedList.append(value);

        assertAll(
                () -> assertEquals(1, myLinkedList.getLenght()),
                () -> assertEquals(myLinkedList.getHead().getValue(), value),
                () -> assertEquals(myLinkedList.getTail().getValue(), value));

        var last = myLinkedList.removeLast();

        assertAll(
                () -> assertEquals(0, myLinkedList.getLenght()),
                () -> assertEquals(null, myLinkedList.getHead()),
                () -> assertEquals(null, last));
    }
}
