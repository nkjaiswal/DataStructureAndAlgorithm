import java.util.Stack;

public class GoldmanSachIncreaseDecreasePattern {

    public static void main(String[] args) {
        System.out.println(findPossibleSmallestNumberMatchingPattern("N"));
        System.out.println(findPossibleSmallestNumberMatchingPattern("MNM"));
    }

    static int findPossibleSmallestNumberMatchingPattern(String pattern) {
        System.out.println(pattern);
        if (pattern == null || pattern.equalsIgnoreCase("") || pattern.length() >= 9)
            return -1;

        Stack<Integer> stack = new Stack<>();

        int sol = 0;

        for (int i=0; i<=pattern.length(); i++) {
            stack.add(i+1);
            if(i < pattern.length() && pattern.charAt(i) != 'M' && pattern.charAt(i) != 'N'){
                return -1;
            }
            if ( i< pattern.length() && pattern.charAt(i) == 'N') {
                while(!stack.isEmpty()) {
                    int n = stack.pop();
                    sol = sol*10 + n;
                }
            }
        }

        while (!stack.isEmpty()) {
            int n = stack.pop();
            sol = sol*10 + n;
        }
        return sol;
    }
}
