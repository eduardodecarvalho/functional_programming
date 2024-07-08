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
        if (index > lenght || index < 0)
            return null;
        var temp = head;
        for (int i = 0; i < lenght; i++) {
            if (i == index) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public boolean set(int index, int value) {
        var temp = get(index);
        if (temp != null) {
            temp.setValue(value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > lenght)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == lenght) {
            append(value);
            return true;
        }
        var temp = get(index - 1);
        var newNode = new MyNode(value);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        lenght++;
        return true;
    }

    public void remove(int index) {
        if (index < 0 || index > lenght)
            return;
        if (index == 0)
            removeFirst();
        if (index == lenght)
            removeLast();
        var previousNode = get(index - 1);
        var nextNode = get(index + 1);
        previousNode.setNext(nextNode);
        lenght--;
    }

    public void reverse() {
        var temp = head;
        MyNode beforeTemp = null;
        head = tail;
        tail = temp;
        for (int i = 0; i < lenght; i++) {
            var afterTemp = temp.getNext();
            temp.setNext(beforeTemp);
            beforeTemp = temp;
            temp = afterTemp;
        }
    }

    public MyNode findMiddleNode() {
        var slow = head;
        var fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    public MyNode findKthFromEnd(int k) {
        var slow = head;
        var fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.getNext();
        }

        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
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
