import java.util.*;

class GFG{

    static int i = 0;
    // Function to find the maximum for each
// and every contiguous subarray of size k 
    static void printKMax(int a[], int n, int k)
    {
        // If k = 1, print all elements
        if (k == 1) {
            for (int i = 0; i < n; i += 1)
                System.out.print(a[i]+ " ");
            return;
        }

        // Using p and q as variable pointers
        // where p iterates through the subarray
        // and q marks end of the subarray.
        int p = 0,
                q = k - 1,
                t = p,
                max = a[k - 1];

        // Iterating through subarray.
        while (q <= n - 1) {
            System.out.println("P=" + p);
            i++;

            // Finding max
            // from the subarray.
            if (a[p] > max)
                max = a[p];

            p += 1;

            // Printing max of subarray
            // and shifting pointers
            // to next index.
            if (q == p && p != n) {
//                System.out.print(max+ " ");
                q++;
                p = ++t;

                if (q < n)
                    max = a[q];
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n = 200;
        int[] a = new int[n];
        Random r = new Random();
        for(int i=0; i<n; i++){
            a[i] = r.nextInt(1000);
        }

        int K = 10;

        printKMax(a, n, K);
        System.out.println("\n" + i + "\n" + n);
    }
} 