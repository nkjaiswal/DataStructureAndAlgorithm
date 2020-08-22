import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Groww1 {
    public static void main(String args[] ) throws Exception {

//        Scanner s = new Scanner(System.in);
//        String name = s.nextLine();
        List<List<Integer>> game = Arrays.asList(
            Arrays.asList(1,0,1), Arrays.asList(1,0,0)
        );
        System.out.println(new Groww1().findWinner(game, game.size(), game.get(0).size()));
    }

    Map<Integer, Boolean> rowMark;
    Map<Integer, Boolean> colMark;
    public String findWinner(List<List<Integer>> game, int n, int m) {
        rowMark = new HashMap<>();
        colMark = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(game.get(i).get(j) == 1) {
                    rowMark.put(i, true);
                    colMark.put(j, true);
                }
            }
        }

        boolean marked;
        int i=0;
        do {
            marked = markCell(game, n, m);
            i++;
        }while(marked);
        return i%2 == 0? "A" : "B";
    }

    private boolean markCell(List<List<Integer>> game, int n, int m) {
        for(int i=0; i<n; i++) {
            if(rowMark.containsKey(i)){
                continue;
            }
            for(int j=0; j<m; j++) {
                if (colMark.containsKey(j)){
                    continue;
                }
                if(game.get(i).get(j) == 1){
                    continue;
                }
                rowMark.put(i, true);
                colMark.put(j, true);
                game.get(i).set(j, 1);
                return true;
            }
        }
        return false;
    }
}
