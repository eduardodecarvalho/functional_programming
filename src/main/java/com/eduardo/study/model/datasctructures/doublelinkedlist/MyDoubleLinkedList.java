package com.eduardo.study.model.datasctructures.doublelinkedlist;

import com.eduardo.study.model.datasctructures.MyNode;

public class MyDoubleLinkedList {
    public MyNode head;
    public MyNode tail;
    public int lenght;

    public MyDoubleLinkedList() {
    }

    public MyDoubleLinkedList(int value) {
        var newNode = new MyNode(value);
        this.head = newNode;
        this.tail = newNode;
        this.lenght = 1;
    }

    public void append(int value) {
        var newNode = new MyNode(value);
        if (lenght == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            var previous = tail;
            previous.setNext(newNode);
            newNode.setPrevious(previous);
            tail = newNode;
        }
        lenght++;
    }
}
