package com.rabinchuk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> list;

    @BeforeEach
    public void setup() {
        list = new CustomLinkedList<>();
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.addFirst(1);
        assertEquals(1, list.size());
        list.addLast(2);
        assertEquals(2, list.size());
        list.addLast(3);
        list.addLast(4);
        assertEquals(4, list.size());
    }

    @Test
    void testAddFirst() {
        list.addFirst(1);
        assertEquals(1, list.getFirst());
        list.addFirst(2);
        assertEquals(2, list.getFirst());
    }

    @Test
    void testAddLast() {
        list.addLast(1);
        assertEquals(1, list.getLast());
        list.addLast(2);
        assertEquals(2, list.getLast());
    }

    @Test
    void testAdd() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(1, 3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void testAddByInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-5, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, -5));
    }

    @Test
    void testGetFirst() {
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
        list.addFirst(1);
        assertEquals(1, list.getFirst());
        list.addLast(2);
        assertEquals(1, list.getFirst());
    }

    @Test
    void testGetLast() {
        assertThrows(NoSuchElementException.class, () -> list.getLast());
        list.addFirst(1);
        assertEquals(1, list.getLast());
        list.addLast(2);
        assertEquals(2, list.getLast());
    }

    @Test
    void testGet() {
        list.addFirst(10);
        list.addLast(2);
        list.addFirst(1);
        assertEquals(10, list.get(1));
        assertThrows(NoSuchElementException.class, () -> list.get(10));
    }

    @Test
    void testRemoveFirst() {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
        list.addFirst(1);
        list.addFirst(2);
        int removed =  list.removeFirst();
        assertEquals(2, removed);
        assertEquals(1, list.getFirst());
        assertEquals(1, list.size());
    }

    @Test
    void testRemoveLast() {
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
        list.addFirst(1);
        list.addLast(2);
        int removed =  list.removeLast();
        assertEquals(2, removed);
        assertEquals(1, list.getLast());
        assertEquals(1, list.size());
    }

    @Test
    void testRemove() {
         list.addFirst(10);
         list.addLast(2);
         list.addFirst(1);
         int removed =  list.remove(1);
         assertEquals(10, removed);
         assertEquals(2, list.size());
    }


}
