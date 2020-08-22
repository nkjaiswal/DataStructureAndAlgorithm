
//{-5,-3,-1,6,9,11}  i = 2
// binary search 0
//left = i;
// right = i+1;
//while you reach end
// abs(a[left]) < abs(a[right])
//      store <- a[left]^2
//      left--;
// else
//       store <- a[right]^2
//      right++;

// -1, -3, -5, 6, 9, 11 O(NlogN)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Triangle {
    static int i = 0;
    static {
        i++;
        System.out.println("hi" + i);
    }
    static Triangle t;

    private Triangle(){

    }

    public static Triangle getInstance() {
        if (t==null)
            t = new Triangle();
        return t;
    }

    public static void main(String[] args) {
        System.out.println("bye" + Triangle.i);
    }
}

public class Walmart {

    public static void main(String[] args) {
        System.out.println(new Walmart().getSquareSortedList(Arrays.asList(-10, -5, -3, -1, 6, 9, 11)));
    }

    public List<Integer> getSquareSortedList(List<Integer> sortedList) {
        int leastNegativeIndex = findFirstNegativeNo(sortedList);
        int left = leastNegativeIndex;
        int right = leastNegativeIndex+1;

        List<Integer> solution = new ArrayList<>();

        while (left >= 0 && right < sortedList.size()) {
            if (Math.abs(sortedList.get(left)) < Math.abs(sortedList.get(right))) {
                solution.add(sortedList.get(left) * sortedList.get(left));
                left--;
            } else {
                solution.add(sortedList.get(right) * sortedList.get(right));
                right++;
            }
        }
        if(left < 0) {
            for(int counter = right; counter < sortedList.size(); counter ++) {
                solution.add(sortedList.get(counter) * sortedList.get(counter));
            }
        } else {
            for(int counter = left; counter >=0; counter --) {
                solution.add(sortedList.get(counter) * sortedList.get(counter));
            }
        }
        return solution;
    }

    public int findFirstNegativeNo(List<Integer> list) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i) >= 0) {
                return i-1;
            }
        }
        return list.size()-1;
    }
}
