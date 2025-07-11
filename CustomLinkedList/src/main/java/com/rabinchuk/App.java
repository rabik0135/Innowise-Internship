package com.rabinchuk;


public class App {
    public static void main( String[] args ) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        System.out.println(list.size());
        list.addFirst(5);
        list.addFirst(4);
        list.addLast(10);
        list.add(1, 52);
        System.out.println(list.get(2));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.size());
        System.out.println(list);
    }
}
