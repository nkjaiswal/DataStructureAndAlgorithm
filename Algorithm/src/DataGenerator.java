import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    public static List<Integer> getSortedArray(int size){
        List<Integer> sol = new ArrayList<>();
        for (int i=0; i<size; i++) {
            if(i==0)
                sol.add(new Random().nextInt(10));
            else
                sol.add(new Random().nextInt(10)+sol.get(i-1));
        }
        return sol;
    }
    public static List<Integer> getSortedArray(){
        return getSortedArray(new Random().nextInt(20) + 10);
    }

    public static boolean isSorted(List<Integer> data) {
        for(int i=1; i<data.size(); i++) {
            if(data.get(i) < data.get(i-1))
                return false;
        }
        return true;
    }
}
