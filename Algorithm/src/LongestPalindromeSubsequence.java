public class LongestPalindromeSubsequence {
    public static void main(String args[]){
        String str = "ABBDCACBCACDBBA";
        System.out.println(new LongestPalindromeSubsequence().getSizeOfLongestPalindromeSubsequence(str,0,str.length()-1));
    }
    int [][]length = new int[20][20];
    int count = 0;
    private int getSizeOfLongestPalindromeSubsequence(String str, int start, int end){
        if(length[start][end] !=0){
            return length[start][end];
        }
        int a = 0, b = 0, c = 0;
        if(start == end){
            return 1;
        }
        if(start > end){
            return 0;
        }
        System.out.println(count++);
        if(str.charAt(start) == str.charAt(end)){
            a = getSizeOfLongestPalindromeSubsequence(str, start+1, end-1) + 1;
        }
        b = getSizeOfLongestPalindromeSubsequence(str, start+1, end);
        c = getSizeOfLongestPalindromeSubsequence(str, start, end-1);
        length[start][end] = Math.max(a,Math.max(b,c));
        return length[start][end];
    }
}
