import java.util.ArrayList;
import java.util.List;

public class Visa {
    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        int k=4;
        System.out.println(countSubarrays(numbers,k));
    }
    public static long countSubarrays(List<Integer> numbers, int k){
        int size = numbers.size();
        long product = 1;
        long count = 0;
        int s = 0;
        int e = 0;
        while(e < size){
            product *= numbers.get(e);
            while(s<e && product >= k){
                product = product / numbers.get(s++);
            }
            if(product < k){
                count = count + e-s+1;
            }
            e++;
        }
        return count;
    }
}
