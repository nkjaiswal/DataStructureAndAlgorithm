import java.util.*;
public class OrderLexigrophycally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            solve(sc);
        }
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();
        int[][] swap = new int[k][2];
        for(int i=0; i<k; i++) {
            swap[i][0] = sc.nextInt();
            swap[i][1] = sc.nextInt();
        }
        boolean b = true;
        int temp = 0;
        while(b){
            b = false;
            for(int i=0; i<n; i++) {
                if(s1[i] > s2[i]){
                    b = true;
                    char temp1 = s1[i];
                    char temp2 = s2[i];
                    s1[i] = temp2;
                    s2[i] = temp1;
                }
            }
            for(int i=0; i<k; i++) {
                List<Character> characters = new ArrayList<>();
                characters.add(s1[swap[i][0]]);
                characters.add(s1[swap[i][1]]);
                characters.add(s2[swap[i][0]]);
                characters.add(s2[swap[i][1]]);

                Collections.sort(characters);
                if(characters.get(0) != s1[swap[i][0]]
                    || characters.get(1) != s1[swap[i][1]]
                    || characters.get(2) != s2[swap[i][0]]
                    || characters.get(3) != s2[swap[i][1]]){
                    b = true;
                }
                s1[swap[i][0]] = characters.get(0);
                s1[swap[i][1]] = characters.get(1);
                s2[swap[i][0]] = characters.get(2);
                s2[swap[i][1]] = characters.get(3);
            }
            temp++;
        }

        System.out.println(new String(s1));
    }
}
