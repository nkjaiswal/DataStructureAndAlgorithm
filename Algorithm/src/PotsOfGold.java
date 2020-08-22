
public class PotsOfGold {
	public static void main(String args[]) {
		int a[] = {1,2,3,4,5,6,7,8,9};
		System.out.print(new PotsOfGold().getMaxPossibleGoldCoin(a, 0, 8));
	}
	int mat[][] = new int[9][9];
	public int getMaxPossibleGoldCoin(int a[], int l, int h) {
		if(l > h) {
			return 0;
		}
		if(mat[l][h]>0) {
			return mat[l][h];
		}else {
			System.out.println(l + " " + h);
			mat[l][h] =  Math.max(a[l] + Math.min(getMaxPossibleGoldCoin(a, l+1, h-1), getMaxPossibleGoldCoin(a, l+2, h)), 
					a[h] + Math.min(getMaxPossibleGoldCoin(a, l, h-2), getMaxPossibleGoldCoin(a, l+1, h-1)));
			return mat[l][h];
		}
	}
}
