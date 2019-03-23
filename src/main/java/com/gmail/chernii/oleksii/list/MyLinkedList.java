package com.gmail.chernii.oleksii.list;


/**
 * Created by Space on 05.03.2019.
 */
public class MyLinkedList<E> implements List<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
    }

    private boolean checkIndex(int index) {
        return index < 0 || index > size - 1;
    }

    @Override
    public void add(E item) {
        Node<E> tempLast = tail;
        Node<E> newNode = new Node<E>(tempLast, item, null);
        tail = newNode;
        if (tempLast == null) {
            head = newNode;
        } else {
            tempLast.next = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (checkIndex(index)) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + size());
        }
        return node(index).item;
    }

    @Override
    public void clear() {
        for (Node<E> temp = head; temp != null; ) {
            Node<E> next = temp.next;
            temp.item = null;
            temp.next = null;
            temp.prev = null;
            temp = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public void remove(int index) {
        if (checkIndex(index)) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + size());
        }
        Node<E> node = node(index);
        Node<E> next = node.next;
        Node<E> prev = node.prev;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.item = null;
        size--;
    }

    private Node<E> node(int index) {
        if (index < (size / 2)) {
            Node<E> temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node<E> temp = this.tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
