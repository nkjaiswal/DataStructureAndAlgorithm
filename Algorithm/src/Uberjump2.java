import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Uberjump2 {

    public static void main(String[] args) {
        Random r = new Random();
        for(int j=0; j<1; j++) {
            int n = 100000;
            int[] path = new int[n];
            for(int i=0; i<n; i++) {
                path[i] = r.nextInt(500) - 1000;
            }
            int k = 5;
            System.out.println(new Uberjump2().arrayJourney(path, k));
        }

    }

    long arrayJourney(int[] path, int k) {
        for(int i=path.length-1; i>=0; i--) {
            int max = Integer.MIN_VALUE;
            if(i==path.length-1)
                continue;
            for(int j=i+1; j<Math.min(path.length, i+k+1); j++) {
                max = Math.max(max, path[j]);
            }
            path[i] = max + path[i];
        }
        return path[0];
    }


}
