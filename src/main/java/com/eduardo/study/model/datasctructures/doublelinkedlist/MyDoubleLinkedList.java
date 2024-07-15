package com.eduardo.study.model.datasctructures.doublelinkedlist;

public class MyDoubleLinkedList {
  public MyNode head;
  public MyNode tail;
  public int lenght;

  public class MyNode {
    public int value;
    public MyNode next;
    public MyNode previous;

    public MyNode(int value) {
      this.value = value;
    }

  }

  public MyDoubleLinkedList() {
  }

  public MyDoubleLinkedList(int value) {
    var newNode = new MyNode(value);
    this.head = newNode;
    this.tail = newNode;
    lenght++;
  }

  public MyDoubleLinkedList(int... values) {
    for (int value : values) {
      append(value);
    }
  }

  public void append(int value) {
    var newNode = new MyNode(value);
    if (lenght == 0) {
      this.head = newNode;
      this.tail = newNode;
      head.next = tail;
      tail.previous = head;
    } else {
      tail.next = newNode;
      newNode.previous = tail;
      tail = newNode;
    }
    lenght++;
  }

  public boolean removeLast() {
    if (lenght == 0) {
      return false;
    }
    if (lenght == 1) {
      head = null;
      tail = null;
    } else {
      tail.previous.next = null;
      tail = tail.previous;
    }
    lenght--;
    return true;
  }

  public void prepend(int value) {
    var newNode = new MyNode(value);
    if (lenght == 0) {
      head = newNode;
      tail = newNode;
    } else {
      head.previous = newNode;
      newNode.next = head;
      head = newNode;
    }
    lenght++;
  }

  public boolean removeFirst() {
    if (lenght == 0) {
      return false;
    }
    if (lenght == 1) {
      head = null;
      tail = null;
    } else {
      var next = head.next;
      next.previous = null;
      head = next;
    }
    lenght--;
    return true;
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
      actual = actual.next;
      i++;
    }
    return null;
  }

  public boolean set(int index, int value) {
    var node = get(index);
    if (node == null)
      return false;
    node.value = value;
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
      var previous = after.previous;
      previous.next = newNode;
      after.previous = newNode;
      newNode.next = after;
      newNode.previous = previous;

      lenght++;
    }
    return true;

  }

  public boolean remove(int index) {
    if (index >= lenght || index < 0) {
      return false;
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == lenght - 1) {
      return removeLast();
    }
    var toRemove = get(index);
    var previous = toRemove.previous;
    var next = toRemove.next;
    previous.next = next;
    next.previous = previous;
    toRemove.previous = null;
    toRemove.next = null;

    lenght--;
    return true;
  }

  public boolean isPalindrome() {
    if (lenght <= 1)
      return true;
    var fromHead = head;
    var fromTail = tail;
    while (fromHead != fromTail) {
      if (fromHead.value != fromTail.value) {
        return false;
      }
      fromHead = fromHead.next;
      fromTail = fromTail.previous;
    }
    return true;
  }

}
