import java.util.Stack;

public class MaxReactangularAreaUnderHisttrogram {

	public static void main(String args[]) {
		int[] hist = {1,2,3,4,5,3,3,2,1,1};
		System.out.println(new MaxReactangularAreaUnderHisttrogram().maxArea(hist));
	}
	public int maxArea(int hist[]) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for(int i=0; i<hist.length; i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}else if(hist[stack.peek()] <= hist[i]) {
				stack.push(i);
			} else {
				int min = Integer.MAX_VALUE;
				int area = 0;
				while(!stack.isEmpty() && hist[stack.peek()] > hist[i]) {
					int top = stack.pop();
					min = Math.min(min, hist[top]);
					area = Math.max(area, min * (i-top));
				}
				maxArea = Math.max(maxArea, area);
			}
		}
		int min = Integer.MAX_VALUE;
		int area = 0;
		int i = 1;
		while(!stack.isEmpty()) {
			int top = stack.pop();
			min = Math.min(min,  hist[top]);
			area = Math.max(area,min * i);
			i++;
		}
		return Math.max(maxArea, area);
	}
}
