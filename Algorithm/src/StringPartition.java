
public class StringPartition {

	public static void main(String args[]) {
		System.out.print(new StringPartition().getMinPartionPallindrome("xAbcdefg",0,7));
	}
	
	Boolean[][] isPalindrome = new Boolean[9][8];
	Integer[][] minPartition = new Integer[8][8];
	public int getMinPartionPallindrome(String str, int s, int e) {
		if(minPartition[s][e]!=null) {
			return minPartition[s][e];
		}
		if(isPalindrome(str,s,e)) {
			return 0;
		}
		int min = 99999;
		for(int i=s; i<e; i++) {
			min = Math.min(getMinPartionPallindrome(str, s, i) + getMinPartionPallindrome(str, i+1, e) +1 , min);
		}
		minPartition[s][e] = min;
		return min;
	}

	private boolean isPalindrome(String str, int s, int e) {
		
		boolean sol = false;
		if (s >= e) {
			return true;
		}
		if(isPalindrome[s][e] != null) {
			return isPalindrome[s][e];
		}
		if(str.charAt(s) == str.charAt(e)) {
			return isPalindrome(str, s+1, e-1);
		}
		isPalindrome[s][e] = sol;
		return sol;
	}
}
