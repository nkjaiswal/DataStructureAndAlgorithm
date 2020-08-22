import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().getLongestPalindrome("forgeeksskeegfor"));
        System.out.println(longestPallindromic("forgeeksskeegfor"));
    }

    private int getLongestPalindrome(String s) {
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            //check for odd palindrome
            int start = i, end = i;
            max = getMax(s, max, start, end);
            //check for even palindrome

            start = i; end = i+1;
            max = getMax(s, max, start, end);
        }
        return max;
    }

    private int getMax(String s, int max, int start, int end) {
        while (start >=0 && end <s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (max < end-start-1){
            System.out.println(s.substring(start+1, end));
            max = end-start-1;
        }
        return max;
    }

    private static String longestPallindromic(String str) {

        char[] data = str.toCharArray();

        Map<Integer,String> result = new TreeMap<>((Collections.reverseOrder()));

        String temp = "";
        for (int i = 0; i < data.length; i++) {
            if(i==0){
                temp += data[i];
                continue;
            }
            temp+=data[i];
            String rev = new StringBuilder(temp).reverse().toString();
            if(str.contains(rev)){
                result.put(temp.length(),temp);
            }else {
                temp = temp.substring(1);
            }

        }
        return result.values().iterator().next();
    }
}
