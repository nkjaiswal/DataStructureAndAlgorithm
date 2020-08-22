import java.util.Arrays;
import java.util.Scanner;
//4 3 9 1 6 1 1 1 1 2 1 3
//6 7 3 2 5 6 2 6 1 2 1 5 2 6 6 6 5 5 5 5 3 5
public class OptimumArrangeArrayForMaxSubArraySum {
    public static void main(String[] args) {
        System.out.println(new OptimumArrangeArrayForMaxSubArraySum().calculate());
    }

    Scanner sc = new Scanner(System.in);

    public int calculate() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] data = new int[n];
        int[] sumData = new int[n];

        for(int i=0; i<n; i++){
            data[i] = sc.nextInt();
            if (i == 0){
                sumData[i] = data[i];
            } else {
                sumData[i] = sumData[i-1] + data[i];
            }
        }
        int[] sortFactor = new int[n];

        int result = 0;
        for(int i=0; i<k; i++) {
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;
            for(int j=s; j<=e; j++)
                sortFactor[j]++;
            result += get(sumData, e) - get(sumData, s-1);

        }
        Arrays.sort(sortFactor);
        Arrays.sort(data);
        int result2 = 0;
        for(int i=0; i<n; i++) {
            result2 += data[i] * sortFactor[i];
        }
        return result2-result;
    }

    int get(int[] a, int index) {
        if (index < 0) {
            return 0;
        }
        return a[index];
    }
}
