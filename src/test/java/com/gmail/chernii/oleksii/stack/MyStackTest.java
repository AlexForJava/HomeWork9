package com.gmail.chernii.oleksii.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {
    private Stack<Integer> stack;
    private final int LENGTH = 5;

    @Before
    public void initStack() {
        stack = new MyStack<Integer>();
        for (int i = 0; i < LENGTH; i++) {
            stack.push(i);
        }
    }

    @After
    public void clearStack() {
        stack.clear();
        stack = null;
    }

    @Test
    public void testPush() throws Exception {
        int beforePush = stack.size();
        stack.push(5);
        int afterPush = stack.size();
        assertTrue(afterPush != beforePush);
    }

    @Test
    public void testSize() throws Exception {
        assertTrue(LENGTH == stack.size());
    }

    @Test
    public void testRemove() throws Exception {
        int beforeRemove = stack.size();
        stack.remove(beforeRemove - 1);
        int afterRemove = stack.size();
        assertTrue(afterRemove != beforeRemove);
    }

    @Test
    public void testClear() throws Exception {
        stack.clear();
        assertTrue(stack.size() == 0);
    }

    @Test
    public void testPeek() throws Exception {
        int actual = 999;
        int sizeBeforePush = stack.size();
        stack.push(actual);
        int expected = stack.peek();
        int sizeAfterPush = stack.size();
        assertTrue(actual == expected && sizeAfterPush != sizeBeforePush);
    }

    @Test
    public void testPop() throws Exception {
        int actual = 999;
        int sizeBeforePush = stack.size();
        stack.push(actual);
        int expected = stack.pop();
        int sizeAfterPush = stack.size();
        assertTrue(actual == expected && sizeAfterPush == sizeBeforePush);
    }
}
