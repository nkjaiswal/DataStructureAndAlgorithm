package google;

import java.util.Arrays;

public class RemoveDuplicateFromArray {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(removeDuplicate(arr)));
    }

    public static int[] removeDuplicate(int[] arr) {
        int left = 0, right = 0;
        int lastElement = arr[0];

        for(int i=1; i<arr.length; i++) {
            if (arr[i] != lastElement) {
                arr[++left] = arr[i];
                lastElement = arr[i];

            }
        }
        return arr;
    }
}
