import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoldmanSachNumberChecker {

    public static void main(String[] args) {
        int n[] = {1456, 345671, 43218, 123};
        System.out.println(findQualifiedNumbers(n));
    }

    static String findQualifiedNumbers(int[] numberArray) {
        List<Integer> values = new ArrayList<>();
        for (int n : numberArray){
            if(isContain123(n)) {
                values.add(n);
            }
        }
        if(values.isEmpty()){
            return "-1";
        }

        Collections.sort(values);
        StringBuilder ret = new StringBuilder();
        for (Integer i: values) {
            ret.append(i).append(",");
        }
        ret.deleteCharAt(ret.length()-1);
        return ret.toString();
    }

    static boolean isContain123(int num) {
        boolean[] is = {false, false, false};
        while (num > 0) {
            int rem = num % 10;
            num = num / 10;
            if (rem < 4 && rem > 0){
                is[rem-1] = true;
            }

            if(is[0] && is[1] && is[2])
                return true;
        }
        return false;
    }
}
