package google;

//Smallest Substring of All Characters
//input:  arr = ['x','y','z'], str = "xyyzyzyx"

import java.util.HashMap;
import java.util.Map;

class SmallestSubstringOfAllChar {
    public static void main(String[] args) {
        char[] arr = {'a','b'};
        String str = "xyxyzyzyxacfghjkbxxa";
        System.out.println(new SmallestSubstringOfAllChar().find(arr, str));
    }

    public String find(char[] chars, String str) {
        int min = Integer.MAX_VALUE;
        int li=0, ri=0;
        Map<Character, Integer> count = new HashMap<>();
        int fullCount = 0;
        for(char ch: chars) {
            count.put(ch, 0);
        }
        int left = 0, right = 0;
        for(char ch: str.toCharArray()) {
            if(count.containsKey(ch) && count.get(ch) == 0) {
                fullCount ++;
            }
            if(count.containsKey(ch)) {
                count.put(ch, count.get(ch)+1);
                do {
                    if (count.containsKey(str.charAt(left)) && count.get(str.charAt(left)) > 1) {
                        count.put(str.charAt(left), count.get(str.charAt(left)) - 1);
                        left++;
                    }
                    if (!count.containsKey(str.charAt(left))) {
                        left++;
                    }
                } while (!count.containsKey(str.charAt(left)) || count.get(str.charAt(left)) > 1);
            }
            if(fullCount == chars.length) {
                if(min > right-left){
                    min = right-left;
                    ri = right;
                    li = left;
                }
            }
            right ++;
        }
        if (min < Integer.MAX_VALUE){
            return str.substring(li, ri+1);
        } else {
            return "";
        }

    }
}