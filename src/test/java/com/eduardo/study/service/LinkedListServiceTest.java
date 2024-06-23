package com.eduardo.study.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                                () -> assertEquals(myLinkedList.getTail().getValue(), value * 2));
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

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemoveLastNode_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(2, myLinkedList.getLenght()),
                                () -> assertEquals(myLinkedList.getHead().getValue(), value),
                                () -> assertEquals(myLinkedList.getTail().getValue(), value * 2));

                var last = myLinkedList.removeLast();

                assertAll(
                                () -> assertEquals(1, myLinkedList.getLenght()),
                                () -> assertEquals(value, myLinkedList.getHead().getValue()),
                                () -> assertEquals(value, last.getValue()));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testPrepend_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(2, myLinkedList.getLenght()),
                                () -> assertEquals(myLinkedList.getHead().getValue(), value),
                                () -> assertEquals(myLinkedList.getTail().getValue(), value * 2));

                myLinkedList.prepend(value * 3);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLenght()),
                                () -> assertEquals(value * 3, myLinkedList.getHead().getValue()),
                                () -> assertEquals(value, myLinkedList.getHead().getNext().getValue()),
                                () -> assertEquals(value * 2, myLinkedList.getTail().getValue()));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemoveFirst_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLenght()),
                                () -> assertEquals(myLinkedList.getHead().getValue(), value),
                                () -> assertEquals(myLinkedList.getTail().getValue(), value * 2));

                myLinkedList.removeFirst();
                assertAll(
                                () -> assertEquals(2, myLinkedList.getLenght()),
                                () -> assertEquals(value * 3, myLinkedList.getHead().getValue()));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testGet_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLenght()),
                                () -> assertEquals(myLinkedList.get(0).getValue(), value),
                                () -> assertEquals(myLinkedList.get(1).getValue(), value * 3),
                                () -> assertEquals(myLinkedList.get(2).getValue(), value * 2));
        }
}
