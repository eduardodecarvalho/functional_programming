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
        this.lenght = 1;
    }

    public void append(int value) {
        var newNode = new MyNode(value);
        if (lenght == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
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

    public void removeFirst() {
        if (lenght == 0)
            return;
        if (lenght == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        lenght--;
    }

    public void prepend(int value) {
        var newNode = new MyNode(value);
        if (lenght == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        lenght++;
    }

    public MyNode get(int index) {
        System.out.println("Index: " + index);
        if (index > lenght)
            return null;
        var temp = head;
        for (int i = 0; i < lenght; i++) {
            if (i - index == 0) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
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
