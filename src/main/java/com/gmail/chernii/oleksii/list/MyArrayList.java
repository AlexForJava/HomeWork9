package com.gmail.chernii.oleksii.list;

import java.util.Arrays;

/**
 * Created by Space on 05.03.2019.
 */
public class MyArrayList<E> implements List<E> {
    private E[] elements;
    private static final int DEFAULT_LENGTH = 10;
    private int size;

    public MyArrayList() {
        this.size = 0;
        elements = (E[]) new Object[DEFAULT_LENGTH];
    }

    @Override
    public void add(E item) {
        if (size < DEFAULT_LENGTH - 1) {
            elements[size++] = item;
        } else {
            int length = elements.length * 2;
            elements = Arrays.copyOf(elements, length);
            elements[size++] = item;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        return elements[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        if (index == size - 1) {
            elements[index] = null;
            size--;
        } else {
            elements[index] = null;
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
