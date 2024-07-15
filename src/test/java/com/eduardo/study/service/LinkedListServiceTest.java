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
                                () -> assertEquals(1, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.getHead().value, value),
                                () -> assertEquals(myLinkedList.getTail().value, value));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testAppendNode_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList();
                myLinkedList.append(value);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(2, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.getHead().value, value),
                                () -> assertEquals(myLinkedList.getTail().value, value * 2));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemoveLastNode_emptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList();
                myLinkedList.append(value);

                assertAll(
                                () -> assertEquals(1, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.getHead().value, value),
                                () -> assertEquals(myLinkedList.getTail().value, value));

                var last = myLinkedList.removeLast();

                assertAll(
                                () -> assertEquals(0, myLinkedList.getLength()),
                                () -> assertEquals(null, myLinkedList.getHead()),
                                () -> assertEquals(null, last));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemoveLastNode_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(2, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.getHead().value, value),
                                () -> assertEquals(myLinkedList.getTail().value, value * 2));

                var last = myLinkedList.removeLast();

                assertAll(
                                () -> assertEquals(1, myLinkedList.getLength()),
                                () -> assertEquals(value, myLinkedList.getHead().value),
                                () -> assertEquals(value, last.value));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testPrepend_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(2, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.getHead().value, value),
                                () -> assertEquals(myLinkedList.getTail().value, value * 2));

                myLinkedList.prepend(value * 3);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(value * 3, myLinkedList.getHead().value),
                                () -> assertEquals(value, myLinkedList.getHead().next.value),
                                () -> assertEquals(value * 2, myLinkedList.getTail().value));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemoveFirst_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.getHead().value, value),
                                () -> assertEquals(myLinkedList.getTail().value, value * 2));

                myLinkedList.removeFirst();
                assertAll(
                                () -> assertEquals(2, myLinkedList.getLength()),
                                () -> assertEquals(value * 3, myLinkedList.getHead().value));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testGet_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value),
                                () -> assertEquals(myLinkedList.get(1).value, value * 3),
                                () -> assertEquals(myLinkedList.get(2).value, value * 2));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testSet_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value),
                                () -> assertEquals(myLinkedList.get(1).value, value * 3),
                                () -> assertEquals(myLinkedList.get(2).value, value * 2));

                myLinkedList.set(0, value * 4);
                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value * 4),
                                () -> assertEquals(myLinkedList.get(1).value, value * 3),
                                () -> assertEquals(myLinkedList.get(2).value, value * 2));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testInsert_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value),
                                () -> assertEquals(myLinkedList.get(1).value, value * 3),
                                () -> assertEquals(myLinkedList.get(2).value, value * 2));

                myLinkedList.insert(1, value * 4);
                assertAll(
                                () -> assertEquals(4, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value),
                                () -> assertEquals(myLinkedList.get(1).value, value * 4),
                                () -> assertEquals(myLinkedList.get(2).value, value * 3),
                                () -> assertEquals(myLinkedList.get(3).value, value * 2));

                myLinkedList.insert(0, value * 5);

                assertAll(
                                () -> assertEquals(5, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value * 5),
                                () -> assertEquals(myLinkedList.get(1).value, value),
                                () -> assertEquals(myLinkedList.get(2).value, value * 4),
                                () -> assertEquals(myLinkedList.get(3).value, value * 3),
                                () -> assertEquals(myLinkedList.get(4).value, value * 2));

        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemove_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value),
                                () -> assertEquals(myLinkedList.get(1).value, value * 3),
                                () -> assertEquals(myLinkedList.get(2).value, value * 2));

                myLinkedList.remove(1);
                assertAll(
                                () -> assertEquals(2, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value),
                                () -> assertEquals(myLinkedList.get(1).value, value * 2));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testReverse_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value),
                                () -> assertEquals(myLinkedList.get(1).value, value * 3),
                                () -> assertEquals(myLinkedList.get(2).value, value * 2));

                myLinkedList.reverse();
                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.get(0).value, value * 2),
                                () -> assertEquals(myLinkedList.get(1).value, value * 3),
                                () -> assertEquals(myLinkedList.get(2).value, value));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testFindMiddleNode_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 2);
                myLinkedList.append(value * 3);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.findMiddleNode().value, value * 2));

                myLinkedList.append(value * 4);

                assertAll(
                                () -> assertEquals(4, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.findMiddleNode().value, value * 3));

                myLinkedList.append(value * 5);
                assertAll(
                                () -> assertEquals(5, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.findMiddleNode().value, value * 3));

                myLinkedList.append(value * 6);
                assertAll(
                                () -> assertEquals(6, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.findMiddleNode().value, value * 4));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1 })
        void testFindKthFromEnd_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 2);
                myLinkedList.append(value * 3);

                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.findKthFromEnd(1), myLinkedList.getTail()),
                                () -> assertEquals(myLinkedList.findKthFromEnd(3), myLinkedList.getHead()),
                                () -> assertEquals(myLinkedList.findKthFromEnd(2).value,
                                                myLinkedList.get(1).value));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1 })
        void testRemoveDuplicates_notEmptyLinkedList(int value) {
                var myLinkedList = new MyLinkedList(value);
                myLinkedList.append(value * 2);
                myLinkedList.append(value * 3);
                myLinkedList.append(value * 2);

                assertAll(
                                () -> assertEquals(4, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.getHead().value, value),
                                () -> assertEquals(myLinkedList.getTail().value, value * 2));

                myLinkedList.removeDuplicates();
                assertAll(
                                () -> assertEquals(3, myLinkedList.getLength()),
                                () -> assertEquals(myLinkedList.getHead().value, value),
                                () -> assertEquals(myLinkedList.getTail().value, value * 3));
        }
}
