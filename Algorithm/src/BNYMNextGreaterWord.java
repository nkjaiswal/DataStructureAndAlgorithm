import java.util.Arrays;

public class BNYMNextGreaterWord {
    public static void main(String[] args) {
        System.out.println(rearrangeWord("bxzua"));
        System.out.println(rearrangeWord("bacba"));
        System.out.println(rearrangeWord("baca"));
    }

    public static String rearrangeWord(String word) {
        int n = word.length();
        int found = -1;
        for(int i=n-1; i>0; i--) {
            if(word.charAt(i) > word.charAt(i-1)) {
                found = i;
                break;
            }
        }
        if(found == -1) {
            return "no answer";
        }

        int replaceWithIndex = found;

        for (int i = found; i < n;  i++ ) {
            if (word.charAt(found-1) < word.charAt(i) && word.charAt(i) < word.charAt(replaceWithIndex)) {
                replaceWithIndex = i;
            }
        }
        char ch1 = word.charAt(replaceWithIndex);
        char ch2 = word.charAt(found-1);

        word = replaceAtI(word, replaceWithIndex, ch2);
        word = replaceAtI(word, found-1, ch1);
        return word.substring(0, found) + sortString(word.substring(found));
    }

    public static String replaceAtI(String str, int index, char ch){
        return str.substring(0, index)
                + ch
                + str.substring(index + 1);
    }
    public static String sortString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
