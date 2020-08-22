import java.util.HashMap;
import java.util.Map;

public class TransformWord {
    public static void main(String[] args) {
        String[] dictionary = {"cat", "bat", "pat", "but", "bun", "sun", "pun", "put"};
        String s1="cat", s2="sun";
        System.out.println(new TransformWord().transform(s1,s2,dictionary,0));
        System.out.println(x);
    }

    public static boolean can(String s1, String s2) {
        if (s1.length() != s2.length())
            throw new AssertionError("Invalid Input");
        int oneFound = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                oneFound++;
            if(oneFound > 1)
                return false;
        }
        return true;
    }
    static int x = 0;
    private Map<String, Integer> cache = new HashMap<>();
    public int transform(String s1, String s2, String[] dictionary, int start) {
        x++;
        if(cache.containsKey(s1+"_"+start))
            return cache.get(s1+"_"+start);

        if (s1.length() != s2.length())
            throw new AssertionError("Invalid Input");
        if(s1.equalsIgnoreCase(s2))
            return 0;
        int cost = 9999;
        for (int i=start; i<dictionary.length; i++){
            if(TransformWord.can(s1, dictionary[i])) {
                cost = Math.min(1 + transform(dictionary[i], s2, dictionary, start+1), cost);
            }
        }
        cache.put(s1+"_"+start, cost);
        return cost;
    }
}
