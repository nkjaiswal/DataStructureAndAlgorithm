import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * 4
 * 5
 * 2
 * 25
 * Start Pushing number to a Stack, if new number is greater than existing print new number.
 * loop it;
 * then push current new number
 */



public class NextGreaterElement {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        Random r = new Random();
        int n = 20;
        for(int i=0; i<n; i++){
            data.add(r.nextInt(30));
        }
        new NextGreaterElement().print(data);
    }

    public void print(List<Integer> data) {
        System.out.println(data);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<data.size(); i++) {
            while (!stack.isEmpty() && data.get(stack.peek()) < data.get(i)){
                System.out.println(data.get(stack.pop())+ " -> " + data.get(i));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            System.out.println(data.get(stack.pop())+ " -> -1");
        }
    }
}
