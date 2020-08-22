public class PallindromePartition {

    public static void main(String[] args) {
        System.out.println(new PallindromePartition().getMinimumPartition("a babbbab b ababa".replaceAll("\\s",""), 0));
//        System.out.println(new PallindromePartition().isPalindrome("ABABA", 0, 4));
    }

    private int getMinimumPartition(String input, int subStringIndex) {
        if(subStringIndex >= input.length()-1)
            return 0;
        if(isPalindrome(input, subStringIndex, input.length()-1)){
            return 0;
        }
        int minChildPartition = 99999;

        for(int index = subStringIndex; index < input.length(); index++) {
            if(isPalindrome(input, subStringIndex, index)) {
                minChildPartition = Math.min(minChildPartition, getMinimumPartition(input, index+1));
            }
        }
        return minChildPartition+1;
    }

    private boolean isPalindrome(String input, int subStringIndex, int index) {
        while (subStringIndex < index) {
            if (input.charAt(subStringIndex) != input.charAt(index)) {
                return false;
            }
            subStringIndex += 1;
            index -= 1;
        }
        return true;
    }

}
