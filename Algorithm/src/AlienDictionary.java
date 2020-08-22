import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {
	public static void main(String args[]) {
		String dict [] = {"baa", "abcd", "abca", "cab", "cad"};
		System.out.print(new AlienDictionary().findCharOrder(dict));
	}

	private String findCharOrder(String[] dict) {
		Map<Character, List<Character>> edgeMap = getAdjucencyMap(dict);
		dfsTravels(edgeMap, 'b');
		String order = "";
		while(!stack.isEmpty()) {
			order += stack.pop();
		}
		return order;
	}
	
	Set<Character> visitedSet = new HashSet<Character>();
	Stack<Character> stack = new Stack<Character>();
	private void dfsTravels(Map<Character, List<Character>> edgeMap, Character c) {
		if(visitedSet.contains(c)) {
			return;
		}
		visitedSet.add(c);
		if(edgeMap.containsKey(c)) {
			for(Character child: edgeMap.get(c)) {
				dfsTravels(edgeMap, child);
			}
		}
		
		stack.add(c);
	}

	private Map<Character, List<Character>> getAdjucencyMap(String[] dict) {
		Map<Character, List<Character>> edgeMap = new HashMap<>();
		for(int i=1; i<dict.length; i++) {
			int j=0;
			while(dict[i-1].charAt(j) == dict[i].charAt(j) && j<dict[i-1].length() && j<dict[i].length()) {
				j++;
			}
			if(j<dict[i].length() && j<dict[i-1].length()) {
				if(!edgeMap.containsKey(dict[i-1].charAt(j))) {
					edgeMap.put(dict[i-1].charAt(j), new ArrayList<>());
				}
				edgeMap.get(dict[i-1].charAt(j)).add(dict[i].charAt(j));
				
			}
		}
		return edgeMap;
	}
}