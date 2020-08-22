import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Orcal {
    public static void main(String[] args) {
        int[] arr = {3,1,8,12,13};
        int target = 11;
        System.out.println(new Orcal().get2NumberSumEqualsTo(arr, target));
    }

    public List<Integer> get2NumberSumEqualsTo(int[] data, int target) {
        Set<Integer> dataSet = new HashSet<>();
        for(int d : data) {
            if (dataSet.contains(target - d)) {
                return Arrays.asList(d, target-d);
            }
            dataSet.add(d);
        }
        return Collections.emptyList();
    }
}

// [a,b] = [b,a]
class Pair{
    int a;

    @java.lang.Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return (a == pair.a && b == pair.b)
                || (b == pair.a && a == pair.b);
    }



    int b;


}