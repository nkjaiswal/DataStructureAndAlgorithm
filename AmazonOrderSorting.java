import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AmazonOrderSorting {
    public static void main(String[] args) {
        System.out.println(new AmazonOrderSorting().sortOrder(6, Arrays.asList("zid 93 12", "fp kindle book", "10a echo show", "17g 12 25 6", "ab kindle book","125 echo dot second")));
    }

    private List<String> sortOrder(int n, List<String> order){
        order.sort(new OrderSorter());
        return order;
    }

    class OrderSorter implements Comparator<String> {
        public int compare(String o1, String o2) {
            if (isPrime(o1) && isPrime(o2)) {
                return match(o1, o2);
            }else if(isPrime(o1) && !isPrime(o2)){
                return -1000000;
            }else if(!isPrime(o1) && isPrime(o2)){
                return 1000000;
            }else{
                return 0;
            }
        }

        private int match(String s1, String s2){
            if(s1.substring(s1.indexOf(' ') + 1).compareTo(s2.substring(s2.indexOf(' ') + 1)) == 0){
                return s1.compareTo(s2);
            }else{
                return s1.substring(s1.indexOf(' ') + 1).compareTo(s2.substring(s2.indexOf(' ') + 1));
            }
        }
        private boolean isPrime(String order){
            List<String> ar = Arrays.asList(order.split(" "));
            ar = ar.subList(1, ar.size());

            return ar.stream().anyMatch(a->!isInteger(a));
        }
    }

    private boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
