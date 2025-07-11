package com.rabinchuk;

import lombok.ToString;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node<T> current = getNode(index - 1);
            Node<T> newNode = new Node<>(value);
            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;

            size++;
        }
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).value;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        T value = tail.value;
        if (tail == head) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return value;
    }

    public T remove(int index) {
        Node<T> removableNode = getNode(index);
        if (removableNode == head) {
            return removeFirst();
        } else if (removableNode == tail) {
            return removeLast();
        } else {
            removableNode.prev.next = removableNode.next;
            removableNode.next.prev = removableNode.prev;
            size--;
            return removableNode.value;
        }
    }


    private Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<T> current = head;
        while (current != null) {
            builder.append(current.value);
            if (current.next != null) {
                builder.append(", ");
            }
            current = current.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
