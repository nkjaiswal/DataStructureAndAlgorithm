import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Median2SortedArray {
    public static void main(String[] args) {
        List<Integer> sortedList1 = DataGenerator.getSortedArray();
        List<Integer> sortedList2 = DataGenerator.getSortedArray();
        System.out.println(sortedList1);
        System.out.println(sortedList2);
        median(sortedList1, sortedList2);
        sortedList1.addAll(sortedList2);
        Collections.sort(sortedList1);
        if(sortedList1.size()%2 ==0){
            System.out.println(sortedList1.get(sortedList1.size()/2) + " | " + sortedList1.get((sortedList1.size()/2) + 1));
        } else {
            System.out.println(sortedList1.get(sortedList1.size()/2));
        }
    }

    private static void median(List<Integer> sortedList1, List<Integer> sortedList2) {
        int set1min=0, set1max=sortedList1.size(), mid1 = set1max/2;
        int set2min=0, set2max=sortedList2.size(), mid2 = set2max/2;
        Scanner s = new Scanner(System.in);
        while(true){
            if (sortedList1.get(mid1) > sortedList2.get(mid2+1)) {
                mid1 = (set1min+mid1)/2;
                mid2 = (mid2 + set2max) / 2;
            } else
            if (sortedList2.get(mid2) > sortedList1.get(mid1+1)) {
                mid2 = (set2min+mid2)/2;
            } else {
                break;
            }
            System.out.println(mid1 + " | " + mid2);
        }
        System.out.println(sortedList1.get(mid1) + " | " + sortedList2.get(mid2));
    }
}
