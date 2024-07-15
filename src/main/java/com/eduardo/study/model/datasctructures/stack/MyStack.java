package com.eduardo.study.model.datasctructures.stack;

public class MyStack {
    MyNode top;
    MyNode next;
    int lenght;

    public class MyNode {
        int value;
        MyNode next;
        MyNode previous;

        public MyNode(int value) {
            this.value = value;
        }

    }

    public MyStack(int value) {
        var newNode = new MyNode(value);
        top = newNode;
        next = newNode;
        lenght++;
    }

}
