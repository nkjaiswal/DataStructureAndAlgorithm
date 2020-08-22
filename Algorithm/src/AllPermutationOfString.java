import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AllPermutationOfString {
    public static void main(String[] args) {
        char a[] = {'t', 'e', 's', 'l', 'a'};
        System.out.println(new HashSet<>(new AllPermutationOfString().getAllPermutation(a, 0)).size());
    }

    private List<String> getAllPermutation(char a[], int start) {
        if(start >= a.length -1){
            return Arrays.asList(a[a.length - 1] + "");
        }
        List<String> prevSol = getAllPermutation(a, start+1);
        List<String> sol = new ArrayList<>();

        for(String s: prevSol) {
            sol.addAll(formAllInsertion(s, a[start]));
        }
        sol.add(a[start] + "");
        sol.addAll(prevSol);
        return sol;
    }

    private List<String> formAllInsertion(String s, char c) {
        List<String> ls = new ArrayList<>();
        for(int i=0; i<= s.length(); i++) {
            ls.add(insertChar(s,c,i));
        }
        return ls;
    }
    private String insertChar(String s, char c, int index) {
        return s.substring(0, index) + c + s.substring(index);
    }
}
