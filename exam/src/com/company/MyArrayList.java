package com.company;

public class MyArrayList {
    private int[] arr;
    private final int DC = 10;
    private int size = 0;

    MyArrayList(){
        arr = new int[DC];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= size; i++) {
            res.append("[").append(i).append("]=").append(arr[i]).append("; ");
        }
        res.append("size=").append(size).append(" length=").append(arr.length);
        return res.toString();
    }

    public void add(int value){
        if (size >= arr.length) {
            int[] t = new int[arr.length * 2];
            for(int i = 0; i < arr.length; i++){
                t[i] = arr[i];
            }
            arr = t;

        }
        arr[size] = value;
        size++;
    }

    public int getByElem(int val) throws Exception {
        for (int i = 0; i < size; i++) {
            if (arr[i] == val){
                return i;
            }
        }
        throw new Exception("Element not found");
    }

    public boolean contains(int val){
        for (int i = 0; i < size; i++) {
            if (arr[i] == val){
                return true;
            }
        }
        return false;
    }
    
    public void delete(int val) throws Exception {
        int ind;
        try {
            ind = getByElem(val);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
        size--;
        for (int i = ind; i < size; i++) {
            arr[i] = arr[i+1];
        }
    }
}
