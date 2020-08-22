import java.util.HashMap;
import java.util.Map;

public class Fraction {
    public static void main(String[] args) {
        new Fraction().print(7, 3);
        new Fraction().print(11, 2);
    }

    public void print(int n, int r) {
        StringBuilder s = new StringBuilder((n / r) + ".");
        Map<Integer, Integer> index = new HashMap<>();
        n = n%r;
        int i=0;
        while(n!=0){
            if(index.containsKey(n)){
                System.out.println(s);
                System.out.println(index.get(n));
                break;
            }
            index.put(n, i);
            while(n < r){
                n = n*10;
                if(n<r)
                    s.append(0);
            }

            s.append(n / r);
            n = n%r;
            i++;
        }
        if(n==0){
            System.out.println(s);
        }
    }
}
