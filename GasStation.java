
public class GasStation {

	public static void main(String args[]) {
		int fuel [] = {2,3,4};
		int cost [] = {3,4,3};
		System.out.print(new GasStation().getStartPosition(fuel, cost));
	}
	
	public int getStartPosition(int fuel[], int cost[]) {
		int sum = 0;
		int pos = -1;
		int newSum = -1;
		for(int i=0; i<cost.length; i++) {
			newSum = (fuel[i] - cost[i] < 0) ? 0 : sum + (fuel[i] - cost[i]);
			if(newSum > 0 && sum == 0 ) {
				pos = i;
			}
			sum = newSum;
		}
		return pos;
	}
}
