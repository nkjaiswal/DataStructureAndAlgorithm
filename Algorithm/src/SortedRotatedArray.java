public class SortedRotatedArray {
    public static void main(String[] args) {
        int a[] = {15, 18, 19, 22, 25, 2, 3, 6, 12, 13, 14};
        System.out.println(new SortedRotatedArray().getRotationIndex(a));

        int b[] = {1,2,3,4,5,6};
        System.out.println(new SortedRotatedArray().getRotationIndex(b));
    }

    public int getRotationIndex(int[] arr) {
        if (arr.length <= 1){
            return arr.length;
        }

        int find = arr[arr.length-1];

        int start = 0, end = arr.length - 1;
        int mid = (start+end)/2;
        int lastMid = -1;
        while(!(arr[mid] > find && arr[mid+1] < find)){
            if(lastMid == mid){
                mid = mid -1;
                break;
            }

            if (arr[mid] < find && arr[mid+1] < find) {
                end = mid;
            } else if (arr[mid] > find && arr[mid+1] > find) {
                start = mid;
            }
            lastMid = mid;
            mid = (start+end)/2;
        }
        return mid+1;
    }
}
