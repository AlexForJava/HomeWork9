package com.gmail.chernii.oleksii.stack;

import java.util.LinkedList;

/**
 * Created by Space on 05.03.2019.
 */
public class MyStack<E> implements Stack<E> {
    private Node<E> top = new Node<E>();
    private int size = 0;

    @Override
    public void push(E item) {
        top = new Node<E>(item, top);
        this.size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        Node<E> temp = new Node<E>();
        for (int i = 0; i < this.size; i++) {
            if (i != index) {
                temp = new Node<E>(pop(), temp);
            } else {
                pop();
            }
        }
        int length = this.size - 1;
        this.size = 0;
        for (int i = 0; i < length; i++) {
            this.push(temp.item);
            temp = temp.next;
        }
    }

    @Override
    public void clear() {
        while (!top.end()) {
            top.item = null;
            top = top.next;
        }
        this.size = 0;
    }

    @Override
    public E peek() {
        return top.item;
    }

    @Override
    public E pop() {
        E result = top.item;
        if (!top.end()) {
            top = top.next;
            this.size--;
        }
        return result;
    }

    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }
}
