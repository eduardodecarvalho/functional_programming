package com.eduardo.study.model.datasctructures.linkedlist;

public class MyLinkedList {
    private MyNode head;
    private MyNode tail;
    private int lenght;

    public MyLinkedList() {
    }

    public MyLinkedList(int value) {
        var newNode = new MyNode(value);
        this.head = newNode;
        this.tail = newNode;
        lenght = 1;
    }

    public void append(int value) {
        var newNode = new MyNode(value);
        if (lenght == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
        }
        lenght++;
    }

    public MyNode removeLast() {
        if (lenght == 0)
            return null;
        var pre = head;
        var temp = head;
        while (temp.getNext() != null) {
            pre = temp;
            temp = temp.getNext();
        }
        tail = pre;
        tail.setNext(null);
        lenght--;
        if (lenght == 0) {
            head = null;
            tail = null;
        }
        return tail;
    }

    public MyNode getHead() {
        return head;
    }

    public void setHead(MyNode head) {
        this.head = head;
    }

    public MyNode getTail() {
        return tail;
    }

    public void setTail(MyNode tail) {
        this.tail = tail;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

}
