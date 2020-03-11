package com.company;

public class HeapSort {
    private static int left(int i){
        return 2*i+1;
    }

    private static int right(int i){
        return 2*(i+1);
    }

    private static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static int[] heapSort(int[] array){
        int heapSize = array.length;
        createHeap(array, heapSize);
        while (heapSize > 0) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            maxHeapify(0, array, heapSize);
        }
        return array;
    }



    public static void createHeap(int[] arr, int heapsize){
        for(int i = heapsize/2; i >= 0; i--){
            maxHeapify(i,arr, heapsize);
        }
    }

    public static void maxHeapify(int index, int[] arr, int heapSize){
        int l = left(index);
        int r = right(index);
        int large = index;
        if(l < heapSize &&
                arr[index] < arr[l]) {
            large = l;
        }
        if(r < heapSize &&
                arr[large] < arr[r]){
            large = r;

        }
        if(index != large){
            swap(arr, index, large);
            maxHeapify(large, arr, heapSize);
        }
    }

}