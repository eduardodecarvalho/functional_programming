package com.eduardo.study.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.eduardo.study.model.datasctructures.doublelinkedlist.MyDoubleLinkedList;

class MyDoubleLinkedListTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15 })
    void testAppend_emptyList(int value) {
        var myDLL = new MyDoubleLinkedList();
        myDLL.append(value);
        assertAll(() -> assertEquals(1, myDLL.lenght),
                () -> assertEquals(myDLL.head, myDLL.tail),
                () -> assertEquals(value, myDLL.head.getValue()));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15 })
    void testAppend_notEmptyList(int value) {
        var myDLL = new MyDoubleLinkedList(value);

        assertAll(() -> assertEquals(1, myDLL.lenght),
                () -> assertEquals(myDLL.head, myDLL.tail));

        myDLL.append(value * 2);
        assertAll(() -> assertEquals(2, myDLL.lenght),
                () -> assertNotEquals(myDLL.head, myDLL.tail),
                () -> assertEquals(value, myDLL.head.getValue()),
                () -> assertEquals(value * 2, myDLL.tail.getValue()));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15 })
    void testRemoveLast_oneElementList(int value) {
        var myDLL = new MyDoubleLinkedList();
        myDLL.append(value);
        assertAll(() -> assertEquals(1, myDLL.lenght),
                () -> assertEquals(myDLL.head, myDLL.tail),
                () -> assertEquals(value, myDLL.head.getValue()));

        myDLL.removeLast();
        assertAll(() -> assertEquals(0, myDLL.lenght),
                () -> assertEquals(null, myDLL.head),
                () -> assertEquals(null, myDLL.tail));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15 })
    void testRemoveLast_notEmptyList(int value) {
        var myDLL = new MyDoubleLinkedList(value);
        myDLL.append(value * 2);
        myDLL.append(value * 3);

        assertAll(() -> assertEquals(3, myDLL.lenght),
                () -> assertNotEquals(myDLL.head, myDLL.tail),
                () -> assertEquals(myDLL.head.getValue(), value),
                () -> assertEquals(myDLL.tail.getValue(), value * 3));

        myDLL.removeLast();
        assertAll(() -> assertEquals(2, myDLL.lenght),
                () -> assertNotEquals(myDLL.head, myDLL.tail),
                () -> assertEquals(value, myDLL.head.getValue()),
                () -> assertEquals(value * 2, myDLL.tail.getValue()),
                () -> assertEquals(myDLL.tail.getPrevious().getValue(), value),
                () -> assertEquals(null, myDLL.tail.getNext()));
    }
}
