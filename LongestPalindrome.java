public class LongestPalindrome {
    public static void main(String[] args) {
//        System.out.println(difference("level")-1 );
    }

    public int difference(String input1) {
        int n = input1.length();
        boolean[][] table = new boolean[n][n];

        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        for (int i = 0; i < n - 1; ++i) {
            if (input1.charAt(i) == input1.charAt(i + 1)) {
                table[i][i + 1] = true;
                maxLength = 2;
            }
        }
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && input1.charAt(i) == input1.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength)
                        maxLength = k;
                }
            }
        }
        return maxLength-1;
    }
}
