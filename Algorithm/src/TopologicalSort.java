import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        Map<Character, Set<Character>> dependencies = new HashMap<>();
        dependencies.put('C', new HashSet<>(Arrays.asList('D', 'E')));
        dependencies.put('B', new HashSet<>(Arrays.asList('C', 'D')));
        dependencies.put('A', new HashSet<>(Arrays.asList('B', 'F')));
        dependencies.put('D', new HashSet<>());
        dependencies.put('E', new HashSet<>());
        dependencies.put('F', new HashSet<>(Arrays.asList('E', 'G')));
        dependencies.put('G', new HashSet<>());

        topologicalSort(dependencies);
    }

    public static void topologicalSort(Map<Character, Set<Character>> dependencies) {
        Stack<Character> stack = new Stack<>();
        Set<Character> alreadyResolved = new HashSet<>();
        for (Map.Entry<Character, Set<Character>> item : dependencies.entrySet()) {
            if (!alreadyResolved.contains(item.getKey())) {
                stack.push(item.getKey());
                alreadyResolved.add(item.getKey());
            }
            while (!stack.isEmpty()) {
                boolean foundUnvisited = false;
                for (Character c : dependencies.get(stack.peek())) {
                    if (!alreadyResolved.contains(c)) {
                        stack.push(c);
                        alreadyResolved.add(c);
                        foundUnvisited = true;
                        break;
                    }
                }
                if (!foundUnvisited)
                    System.out.println(stack.pop());

            }
        }
    }
}
