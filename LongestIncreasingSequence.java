
public class LongestIncreasingSequence {
	public static void main(String args[]) {
		int data [] = {100, 9, 33, 21, 50, 41, 60, 80, 10, 11, 12, 13, 14, 15, 16, 17,18, 19, 1, 2, 3, 4, 5};
		System.out.print(new LongestIncreasingSequence().getLongestSequenceSize(data));
	}
	public int getLongestSequenceSize(int data[]) {
		LongestIncreasingSequence x = new LongestIncreasingSequence();
		int max = 0;
		for(int i=0; i<data.length; i++) {
			max = Math.max(max,x.getLongestSequenceSize(data, i));
		}
		return max;
	}
	int[] longestSequenceSize = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int count = 0;
	public int getLongestSequenceSize(int data[], int from) {
		if(longestSequenceSize[from] !=0) {
			return longestSequenceSize[from];
		}
		if(data.length == from-1) {
			return 1;
		}
		int size = 0;
		for(int i=from+1; i<data.length; i++) {
			System.out.println(count++ + "# " + from);
			if(data[i]>data[from]) {
				size = Math.max(getLongestSequenceSize(data, i),size);
			}
		}
		longestSequenceSize[from] = size+1;
		return size+1;
	}
}
