import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UberArrayJump {

    public static void main(String[] args) {
        int[] path = {10, 2, -10, 5, 20};

        int k = 2;
        System.out.println(new UberArrayJump().arrayJourney(path, k));

    }

    long arrayJourney(int[] path, int k) {
        return collectAndJump(path, k, 0);
    }

    Map<Integer, Long> cache = new HashMap<>();

    long collectAndJump(int[] path, int k, int index) {

//        if(cache.containsKey(index)){
//            return cache.get(index);
//        }
        if (index == path.length-1) {
            return path[index];
        }
        long sol = Integer.MIN_VALUE;
        for (int i=index+1; i<Math.min(index+k+1,path.length); i++) {
            long subSol = collectAndJump(path, k, i);
            sol = Math.max(sol, path[index] + subSol);
        }
        cache.put(index, sol);
        return sol;
    }
}
