import java.util.HashMap;
import java.util.Map;

public class BNYMFirstRepeatingChar {

    public static void main(String[] args) {
        System.out.println(firstRepeatingLetter("abcba"));
    }

    public static String firstRepeatingLetter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        int i=0;
        for (Character c : s.toCharArray()){
            if(map.containsKey(c)) {
                minIndex = Math.min(minIndex, map.get(c));
            } else {
                map.put(c, i);
            }
            i++;
        }
        return s.charAt(minIndex) + "";
    }
}
