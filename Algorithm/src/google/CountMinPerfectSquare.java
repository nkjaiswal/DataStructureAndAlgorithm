package google;

import java.util.HashMap;
import java.util.Map;

public class CountMinPerfectSquare {
    public static void main(String[] args) {

        Runnable r = () -> {
            while(true) {
                System.out.println("Total Count of Calculation: " + counter/10000000 + " crore");
                try{
                    Thread.sleep(500);
                }catch (Exception e) {
                    System.out.println(e);
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
        System.out.println(getMinCountOfPerfectSquare(63, true));
        System.out.println("Final Count of Calculation: " + counter);
        t.stop();
    }

    private static boolean isPerfectSquare(int n) {
        return n == getFloorPerfectSquare(n);
    }

    private static int getFloorPerfectSquare(int n) {
        return (int)(Math.pow(getFloorPerfectSquareRoot(n),2));
    }

    private static int getFloorPerfectSquareRoot(int n) {
        return (int)(Math.sqrt(n));
    }
    static long counter = 0;
    static Map<Integer, Integer> cache = new HashMap<>();
    private static int getMinCountOfPerfectSquare(int n, boolean cachingAllowed) {
        if(isPerfectSquare(n)){
            return 1;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }

        int initSqrt = getFloorPerfectSquareRoot(n);
        int minCount = Integer.MAX_VALUE;
        for(int i=initSqrt; i>=1; i--) {
            minCount = Math.min(1 + getMinCountOfPerfectSquare(n - i*i, cachingAllowed), minCount);
        }
        if(cachingAllowed)
            cache.put(n, minCount);
        counter++;
        return minCount;
    }
}
