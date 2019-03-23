package com.gmail.chernii.oleksii.list;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest extends Assert {
    private List<String> list;
    private String[] strings = {"one", "two", "three", "four", "five"};
    private String string = "string";

    @Before
    public void fillList() {
        list = new MyArrayList<String>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
    }

    @After
    public void clearList() {
        list.clear();
        list = null;
    }

    @Test
    public void testAdd() throws Exception {
        int beforeAdd = list.size();
        list.add(string);
        int afterAdd = list.size();
        assertFalse(afterAdd == beforeAdd);
    }

    @Test
    public void testGet() throws Exception {
        String[] stringsList = new String[list.size()];
        for (int i = 0; i < stringsList.length; i++) {
            stringsList[i] = list.get(i);
        }
        assertArrayEquals(strings, stringsList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() throws Exception {
        list.get(-1);
    }

    @Test
    public void testRemove() throws Exception {
        int before = list.size();
        list.remove(before - 1);
        int after = list.size();
        assertFalse(after == before);
    }

    @Test
    public void testSize() throws Exception {
        assertTrue(list.size() == strings.length);
    }

    @Test
    public void testClear() throws Exception {
        list.clear();
        assertTrue(list.size() == 0);
    }
}
