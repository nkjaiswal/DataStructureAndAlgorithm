import java.util.Stack;

/**
 * Given a List of parenthesis, make it balanced with least number of replace operations
 */

public class MakeStringBalanced {
    public static void main(String[] args) {
        System.out.println(new MakeStringBalanced().getMinimumReplacement(")))((("));
    }

    private Stack<Character> stack = new Stack<>();

    public int getMinimumReplacement(String query) {
        stack = new Stack<>();
        for(Character ch : query.toCharArray()) {
            this.push(ch);
        }
        int replaceCounter = 0;
        while(!this.stack.isEmpty()) {
            Character firstPop = stack.pop();
            Character secondPop = stack.pop();
            if (firstPop.equals(secondPop)) {
                replaceCounter += 1; //case: (( or )) can be converted to () by replacing 1 char
            } else {
                replaceCounter += 2; //case: )( can be converted to () by replacing 2 char
            }
        }
        return replaceCounter;
    }

    private static Character OPENING_BRACKET = '(';
    private static Character CLOSING_BRACKET = ')';

    private void push(Character ch) {
        if (stack.isEmpty()) {
            stack.push(ch);
        } else {
            if (OPENING_BRACKET.equals(stack.peek()) && CLOSING_BRACKET.equals(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
    }
}
