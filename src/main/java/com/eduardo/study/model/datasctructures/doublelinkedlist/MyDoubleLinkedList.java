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
            head.setNext(tail);
            tail.setPrevious(head);
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        lenght++;
    }

    public void removeLast() {
        if (lenght == 0) {
            return;
        }
        if (lenght == 1) {
            head = null;
            tail = null;
        } else {
            tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
        }
        lenght--;
    }

    public void prepend(int value) {
        var newNode = new MyNode(value);
        if (lenght == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        lenght++;
    }
}
