package com.gmail.chernii.oleksii.list;

/**
 * Created by Space on 05.03.2019.
 */
public interface List<E> {
    void add(E item);

    E get(int index);

    void remove(int index);

    int size();

    void clear();
}
