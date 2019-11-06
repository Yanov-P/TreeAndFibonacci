import java.util.HashMap;
import java.util.Random;

public class Main {
//    static int[] array;
    public static void main(String[] args) {
        int[] array = genArray(10);
        print(array);
        print(mergeSort(array));
    }



    public static void print(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i < array.length-1){
                System.out.print(", ");
            }
            else System.out.print("]");
        }
        System.out.println("");
    }
    public static int [] genArray(int n){
        Random r = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(100);
        }
        return array;
    }

    public static int[] mergeSort(int[] array){
        if(array.length == 1) {                                     // c1 2n-1
            return array;
        }
        int middleIndex = array.length / 2;                        // c2 n-1
        int[] left = new int[middleIndex];                         // c3 n-1
        int[] right = new int[array.length - middleIndex];         // c4 n-1
        for (int i = 0; i < array.length; i++) {                   // c5 (n-1)n
            if(i<middleIndex){                                      // c6
                left[i] = array[i];
            } else{
                right[i-middleIndex] = array[i];
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right){
        int[] res = new int[left.length + right.length];
        int lIndex = 0;
        int rIndex = 0;
        int index = 0;
        while(lIndex < left.length && rIndex < right.length){
            if(left[lIndex] <= right[rIndex]){
                res[index] = left[lIndex];
                index++;
                lIndex++;
            } else{
                res[index] = right[rIndex];
                index++;
                rIndex++;
            }
        }
        for (int i = lIndex; i < left.length; i++) {
            res[index] = left[i];
            index++;
        }
        for (int i = rIndex; i < right.length; i++) {
            res[index] = right[i];
            index++;
        }
        return res;
    }

    public static int[] insertSort(int[] array){
        for (int i = 1; i < array.length - 1; i++) {        //c1 n-1
            int value = array[i];                           //c2 n-1
            int prev = i-1;                                 //c3 n-1
            while(prev >= 0 && value < array[prev]){        //c4 n-1
                array[prev + 1] = array[prev];              //c5 (n-1)T, где 0 <= T <= i
                prev--;                                     //c6 (n-1)T, где 0 <= T <= i
            }
            array[prev+1] = value;                          //c7 (n-1)
        }                                                   //A n^2 + B n + C
        return array;
    }

    public static int[] chooseSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {        //c1 n-1
            int minIndex = i;                               //c2 n-1
            for (int j = i + 1; j < array.length; j++) {    //c3 (n-1)(n-i-1)
                if(array[j] < array[minIndex]){             //c4 (n-1)(n-i-1)
                    minIndex = j;                           //c5 0 <= Ti <= (n-1)(n-i-1)
                }
            }
            if(i != minIndex) {                             //c6 n-1
                int temp = array[minIndex];                 //c7 0 <= Ti <= (n-1)
                array[minIndex] = array[i];                 //c8 0 <= Ti <= (n-1)
                array[i] = temp;                            //c9 0 <= Ti <= (n-1)
            }
        }                                                   // A n^2 + B n + C
        return array;
    }

    public static int[] bubbleSort(int[] array){                // n = array.length
        for (int i = 0; i < array.length - 1; i++) {            // c1 n-1
            for (int j = i + 1; j < array.length; j++) {        // c2 (n-i-1) * (n-1)
                if(array[i] > array[j]){                        // c3 (n-i-1) * (n-1)
                    int c = array[i];                           // c4 0 <= t[i] <= (n-i-1) * (n-1)
                    array[i] = array[j];                        // c5 0 <= t[i] <= (n-i-1) * (n-1)
                    array[j] = c;                               // c6 0 <= t[i] <= (n-i-1) * (n-1)
                }
            }                                                   // A * n^2 + B * n + C
        }                                                       // даже если пузырек получит отсортированный массив,
        return array;                                           // то все равно будет долга
    }
}