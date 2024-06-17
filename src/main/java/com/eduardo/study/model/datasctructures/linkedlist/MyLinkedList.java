package com.eduardo.study.model.datasctructures.linkedlist;

public class MyLinkedList {
    private MyNode haed;
    private MyNode tail;
    private int lenght;

    public MyLinkedList() {
    }

    public MyLinkedList(int value) {
        var newNode = new MyNode(value);
        this.haed = newNode;
        this.tail = newNode;
        this.lenght = 1;
    }

    public MyNode getHaed() {
        return haed;
    }

    public void setHaed(MyNode haed) {
        this.haed = haed;
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
