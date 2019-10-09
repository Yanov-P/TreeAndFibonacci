import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static HashMap<Integer, Long> mapFib = new HashMap<Integer, Long>();

    public static long fib(int n){
        long current = 1L;
        long prev = 1;
        for (int i = 0; i < n; i++) {
            long temp = current;
            current += prev;
            prev = temp;
        }
        return current;
    }

    public static long memoryFib(int n){
        if(mapFib.containsKey(n)){
            return mapFib.get(n);
        }
        else {
            if(mapFib.size() == 0) initializeMap();
            int size = mapFib.size();
            fib(mapFib.get(size-1), mapFib.get(size), size, n);
        }
        return mapFib.get(n);
    }

    private static void initializeMap() {
        mapFib.put(1,1L);
        mapFib.put(2,1L);
    }

    private static long fib(long prev, long current, int curIndex, int lastIndex){
        long p = prev;
        long c = current;
        for (int i = curIndex + 1; i < lastIndex + 1; i++) {
            long temp = c;
            c += p;
            p = temp;
            mapFib.put(i, c);
        }
        return c;
    }

    public static void printMapSize(){
        System.out.println("mapFib size = " + mapFib.size());
    }
}
