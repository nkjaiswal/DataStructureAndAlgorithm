
public class WaysToReachBottomRightCornerInKTurn {
	
	public static void main(String args[]) {
		System.out.print(new WaysToReachBottomRightCornerInKTurn().waysCount(2, 2, 1, Direction.ANY));
	}

	int count = 0;
	int [][][][] ways = new int[15][15][15][3];
	
	
	public int waysCount(int m, int n, int k, Direction direction) {
		int sol = 0;
		if(m < 0 || n < 0 || k < 0) {
			return 0;
		}
		if(ways[m][n][k][direction.ordinal()] != 0) {
			return ways[m][n][k][direction.ordinal()];
		}
		if(m ==0 && n == 0) {
			if(k == 0) {
				sol = 1;
			}else {
				sol = 0;
			}
		}else {
			System.out.println("Count # " + count++);
			if(direction == Direction.ANY) {
				sol =  waysCount(m, n-1, k, Direction.RIGHT) + waysCount(m-1, n, k, Direction.BOTTOM);
			}else if(direction == Direction.RIGHT) {
				sol = waysCount(m-1, n, k-1, Direction.BOTTOM) + waysCount(m, n-1, k, Direction.RIGHT) ;
			}else if(direction == Direction.BOTTOM) {
				sol = waysCount(m-1, n, k, Direction.BOTTOM) + waysCount(m, n-1, k-1, Direction.RIGHT) ;
			}else {
				throw new RuntimeException("Not a valid move");
			}
		}
		ways[m][n][k][direction.ordinal()] = sol;
		return sol;
	}
	
	enum Direction{
		RIGHT, BOTTOM, ANY
	}
}
