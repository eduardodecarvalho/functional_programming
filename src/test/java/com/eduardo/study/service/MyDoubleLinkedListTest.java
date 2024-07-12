package com.eduardo.study.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testPrepend_notEmptyList(int value) {
                var myDLL = new MyDoubleLinkedList(value);
                myDLL.append(value * 2);
                myDLL.append(value * 3);

                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertNotEquals(myDLL.head, myDLL.tail),
                                () -> assertEquals(myDLL.head.getValue(), value),
                                () -> assertEquals(myDLL.tail.getValue(), value * 3));

                myDLL.prepend(value * 4);
                assertAll(() -> assertEquals(4, myDLL.lenght),
                                () -> assertEquals(myDLL.head.getValue(), value * 4));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testPrepend_emptyList(int value) {
                var myDLL = new MyDoubleLinkedList();
                myDLL.prepend(value);

                assertAll(() -> assertEquals(1, myDLL.lenght),
                                () -> assertEquals(myDLL.head, myDLL.tail),
                                () -> assertEquals(myDLL.head.getValue(), value),
                                () -> assertEquals(myDLL.tail.getValue(), value));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemoveFirst_oneElementList(int value) {
                var myDLL = new MyDoubleLinkedList(value);

                assertAll(() -> assertEquals(1, myDLL.lenght),
                                () -> assertEquals(myDLL.head, myDLL.tail),
                                () -> assertEquals(myDLL.head.getValue(), value),
                                () -> assertEquals(myDLL.tail.getValue(), value));

                myDLL.removeFirst();
                assertAll(() -> assertEquals(0, myDLL.lenght),
                                () -> assertEquals(null, myDLL.head),
                                () -> assertEquals(null, myDLL.tail));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemoveFirst_moreThanOneElementList(int value) {
                var myDLL = new MyDoubleLinkedList(value);
                myDLL.append(value * 2);
                myDLL.append(value * 3);

                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertEquals(myDLL.head.getValue(), value),
                                () -> assertEquals(myDLL.head.getNext().getValue(), value * 2),
                                () -> assertEquals(null, myDLL.head.getPrevious()),
                                () -> assertEquals(myDLL.tail.getValue(), value * 3));

                myDLL.removeFirst();
                assertAll(() -> assertEquals(2, myDLL.lenght),
                                () -> assertEquals(value * 2, myDLL.head.getValue()),
                                () -> assertEquals(myDLL.head.getNext().getValue(), value * 3),
                                () -> assertEquals(null, myDLL.head.getPrevious()),
                                () -> assertEquals(value * 3, myDLL.tail.getValue()));

                myDLL.removeFirst();
                assertAll(() -> assertEquals(1, myDLL.lenght),
                                () -> assertEquals(value * 3, myDLL.head.getValue()),
                                () -> assertEquals(null, myDLL.head.getNext()),
                                () -> assertEquals(value * 3, myDLL.tail.getValue()));

                myDLL.removeFirst();
                assertAll(() -> assertEquals(0, myDLL.lenght),
                                () -> assertEquals(null, myDLL.head),
                                () -> assertEquals(null, myDLL.tail));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testGet_moreThanOneElementList(int value) {
                var myDLL = new MyDoubleLinkedList(value);
                myDLL.append(value * 2);
                myDLL.append(value * 3);

                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertEquals(myDLL.get(0).getValue(), value),
                                () -> assertEquals(myDLL.get(1).getValue(), value * 2),
                                () -> assertEquals(myDLL.get(2).getValue(), value * 3));

                myDLL.removeFirst();
                assertAll(() -> assertEquals(2, myDLL.lenght),
                                () -> assertEquals(myDLL.get(0).getValue(), value * 2),
                                () -> assertEquals(myDLL.get(1).getValue(), value * 3));
                myDLL.removeFirst();
                assertAll(() -> assertEquals(1, myDLL.lenght),
                                () -> assertEquals(myDLL.get(0).getValue(), value * 3));
                myDLL.removeFirst();
                assertAll(() -> assertEquals(0, myDLL.lenght),
                                () -> assertEquals(null, myDLL.get(0)));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testSet_moreThanOneElementList(int value) {
                var myDLL = new MyDoubleLinkedList(value);
                myDLL.append(value * 2);
                myDLL.append(value * 3);

                boolean biggerThanLenght = myDLL.set(myDLL.lenght + 1, value * 4);
                boolean invalidLenght = myDLL.set(-1, value * 4);
                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertEquals(myDLL.get(0).getValue(), value),
                                () -> assertEquals(myDLL.get(1).getValue(), value * 2),
                                () -> assertEquals(myDLL.get(2).getValue(), value * 3),
                                () -> assertFalse(biggerThanLenght),
                                () -> assertFalse(invalidLenght));

                myDLL.set(0, value * 4);
                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertEquals(myDLL.get(0).getValue(), value * 4),
                                () -> assertEquals(myDLL.get(1).getValue(), value * 2),
                                () -> assertEquals(myDLL.get(2).getValue(), value * 3));

                myDLL.set(1, value * 5);
                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertEquals(myDLL.get(0).getValue(), value * 4),
                                () -> assertEquals(myDLL.get(1).getValue(), value * 5),
                                () -> assertEquals(myDLL.get(2).getValue(), value * 3));
                myDLL.set(2, value * 6);
                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertEquals(myDLL.get(0).getValue(), value * 4),
                                () -> assertEquals(myDLL.get(1).getValue(), value * 5),
                                () -> assertEquals(myDLL.get(2).getValue(), value * 6));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testInsert_emptyList(int value) {
                var myDLL = new MyDoubleLinkedList();
                myDLL.insert(0, value);

                assertAll(() -> assertEquals(1, myDLL.lenght),
                                () -> assertEquals(myDLL.head, myDLL.tail),
                                () -> assertEquals(myDLL.head.getValue(), value),
                                () -> assertEquals(myDLL.tail.getValue(), value));

                myDLL.insert(0, value * 2);
                assertAll(() -> assertEquals(2, myDLL.lenght),
                                () -> assertNotEquals(myDLL.head, myDLL.tail),
                                () -> assertEquals(myDLL.get(0).getValue(), value * 2),

                                () -> assertEquals(myDLL.get(1).getValue(), value));

                myDLL.insert(2, value * 3);
                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertNotEquals(myDLL.head, myDLL.tail),
                                () -> assertEquals(myDLL.get(0).getValue(), value * 2),
                                () -> assertEquals(myDLL.get(1).getValue(), value),
                                () -> assertEquals(myDLL.get(2).getValue(), value * 3),
                                () -> assertEquals(myDLL.tail.getValue(), value * 3));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 3, 5, -3, 15 })
        void testRemove_emptyList(int value) {
                var myDLL = new MyDoubleLinkedList(value);
                myDLL.append(value * 2);
                myDLL.append(value * 3);
                myDLL.append(value * 4);
                myDLL.append(value * 5);

                assertAll(() -> assertEquals(5, myDLL.lenght));

                myDLL.remove(0);
                assertAll(() -> assertEquals(4, myDLL.lenght),
                                () -> assertEquals(myDLL.head.getValue(), value * 2),
                                () -> assertEquals(myDLL.get(1).getValue(), value * 3),
                                () -> assertEquals(myDLL.get(2).getValue(), value * 4));

                myDLL.remove(1);
                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertEquals(myDLL.get(1).getValue(), value * 4));

                boolean equalsToLenght = myDLL.remove(myDLL.lenght);
                boolean invalidLenght = myDLL.remove(-1);
                assertAll(() -> assertEquals(3, myDLL.lenght),
                                () -> assertEquals(myDLL.tail.getValue(), value * 5),
                                () -> assertFalse(equalsToLenght),
                                () -> assertFalse(invalidLenght));

        }

        @ParameterizedTest
        @MethodSource("isPalindromeValues")
        void testIsPalindrome_emptyList(boolean isPalindrome, MyDoubleLinkedList myDLL) {
                assertEquals(isPalindrome, myDLL.isPalindrome());
        }

        private static Stream<Arguments> isPalindromeValues() {
                return Stream.of(
                                Arguments.of(true, new MyDoubleLinkedList(1)),
                                Arguments.of(true, new MyDoubleLinkedList(1, 2, 1)),
                                Arguments.of(false, new MyDoubleLinkedList(1, 2, 1, 1)),
                                Arguments.of(false, new MyDoubleLinkedList(1, 2, 3, 4, 5)),
                                Arguments.of(true, new MyDoubleLinkedList(1, 2, 3, 2, 1)));
        }
}
