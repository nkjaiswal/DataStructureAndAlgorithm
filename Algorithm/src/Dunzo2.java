import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dunzo2 {
    public static void main(String[] args) {
        System.out.println(threePalindromicSubstrings("kayakabapqp"));
//        System.out.println(get2SubString("abapqp"));
    }

    static boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start ++; end --;
        }
        return true;
    }

    public static List<String> threePalindromicSubstrings(String word) {
        for (int i=1; i<word.length(); i++) {
            if (isPalindrome(word.substring(0, i))) {
                List<String> subs = get2SubString(word.substring(i), i);
                System.out.println(word.substring(i) + subs);
                if(!subs.isEmpty()) {
                    return Arrays.asList(word.substring(0, i), subs.get(0), subs.get(1));
                }
            }
        }
        return Collections.singletonList("Impossible");
    }

    static Map<Integer, Boolean> cache = new HashMap<>();

    private static List<String> get2SubString(String substring, int index) {
        for(int i=1; i<substring.length(); i++) {
            if(cache.containsKey(i+index)){
                continue;
            }
            if(isPalindrome(substring.substring(0, i))){

                if(isPalindrome(substring.substring(i))){
                    List<String> subs = new ArrayList<>();
                    subs.add(substring.substring(0, i));
                    subs.add(substring.substring(i));
                    return subs;
                } else {
                    cache.put(i+index, false);
                }
            }
        }
        return Collections.emptyList();
    }
}
