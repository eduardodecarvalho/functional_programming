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

  public void removeFirst() {
    if (lenght == 0) {
      return;
    }
    if (lenght == 1) {
      head = null;
      tail = null;
    } else {
      var next = head.getNext();
      next.setPrevious(null);
      head = next;
    }
    lenght--;
  }

  public MyNode get(int index) {
    if (index > lenght || index < 0) {
      return null;
    }
    var actual = head;
    int i = 0;
    while (actual != null) {
      if (i == index) {
        return actual;
      }
      actual = actual.getNext();
      i++;
    }
    return null;
  }

  public boolean set(int index, int value) {
    var node = get(index);
    if (node == null)
      return false;
    node.setValue(value);
    return true;
  }

  public boolean insert(int index, int value) {
    if (index > lenght || index < 0) {
      return false;
    } else if (index == 0) {
      prepend(value);
    } else if (index == lenght) {
      append(value);
    } else {
      var newNode = new MyNode(value);
      var after = get(index);
      var previous = after.getPrevious();
      previous.setNext(newNode);
      after.setPrevious(newNode);
      newNode.setNext(after);
      newNode.setPrevious(previous);

      lenght++;
    }
    return true;

  }

}
