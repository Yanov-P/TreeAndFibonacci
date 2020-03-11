package com.company;

public class Main {

    public static void main(String[] args) {
//        MyArrayList l = new MyArrayList();
//        l.add(1);
//        l.add(56);
//        System.out.println(l.toString());
//        for (int i = 0; i < 9; i++) {
//            l.add(5);
//        }
//        l.add(21);
//        System.out.println(l.toString());
//        for (int i = 0; i < 20; i++) {
//            l.add(6);
//        }
//        System.out.println(l.toString());
//        System.out.println("Contains 21: " + l.contains(21));
//        System.out.println("Contains 25: " + l.contains(25));
//        l.delete(21);
//        System.out.println(l.toString());

        int[] array = {8, 2, 4, 9, 5, 7, 6, 2, 15, 7};
        array = HeapSort.heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }

    }
}
