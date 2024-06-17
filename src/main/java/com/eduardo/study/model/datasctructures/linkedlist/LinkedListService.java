package com.eduardo.study.model.datasctructures.linkedlist;

import org.springframework.stereotype.Service;

@Service
public class LinkedListService {

    public MyLinkedList appendNode(int value) {
        var linkedList = new MyLinkedList(value);
        return linkedList;
    }
}
