package com.gmail.chernii.oleksii.stack;

/**
 * Created by Space on 05.03.2019.
 */
public interface Stack<E> {
    void push(E item);

    void remove(int index);

    void clear();

    E peek();

    E pop();

    int size();
}
