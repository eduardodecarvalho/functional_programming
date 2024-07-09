package com.eduardo.study.model.datasctructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.eduardo.study.model.datasctructures.MyNode;

public class MyLinkedList {
    private MyNode head;
    private MyNode tail;
    private int length;

    public MyLinkedList() {
    }

    public MyLinkedList(int value) {
        var newNode = new MyNode(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value) {
        var newNode = new MyNode(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    public MyNode removeLast() {
        if (length == 0)
            return null;
        var pre = head;
        var temp = head;
        while (temp.getNext() != null) {
            pre = temp;
            temp = temp.getNext();
        }
        tail = pre;
        tail.setNext(null);
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return tail;
    }

    public void removeFirst() {
        if (length == 0)
            return;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        length--;
    }

    public void prepend(int value) {
        var newNode = new MyNode(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        length++;
    }

    public MyNode get(int index) {
        if (index > length || index < 0)
            return null;
        var temp = head;
        for (int i = 0; i < length; i++) {
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
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        var temp = get(index - 1);
        var newNode = new MyNode(value);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        length++;
        return true;
    }

    public void remove(int index) {
        if (index < 0 || index > length)
            return;
        if (index == 0)
            removeFirst();
        if (index == length)
            removeLast();
        var previousNode = get(index - 1);
        var nextNode = get(index + 1);
        previousNode.setNext(nextNode);
        length--;
    }

    public void reverse() {
        var temp = head;
        MyNode beforeTemp = null;
        head = tail;
        tail = temp;
        for (int i = 0; i < length; i++) {
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

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        MyNode previous = null;
        var current = head;
        while (current != null) {
            if (values.contains(current.getValue())) {
                previous.setNext(current.getNext());
                length--;
            } else {
                values.add(current.getValue());
                tail = current;
                previous = current;
            }
            current = current.getNext();
        }
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

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

}
