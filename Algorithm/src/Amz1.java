// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
 class Solution1
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations, 
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
	{
    	List<Data> d = new ArrayList<>();
    	for(int i=0; i<allLocations.size(); i++) {
    		Data d1 = new Data();
    		d1.sol = allLocations.get(i);
    		d1.distance = Math.sqrt(d1.sol.get(0)*d1.sol.get(0) + d1.sol.get(1)*d1.sol.get(1));
    		d.add(d1);
    		
    	}
    	d.sort((d1,d2)->{
    		if (d1.distance.compareTo(d2.distance) == 0) {
                return 0;
            } else {
                return d1.distance.compareTo(d2.distance);
            } 
    	});
    	List<List<Integer>> sol = new ArrayList<>();
    	for(int i=0; i<numDeliveries; i++) {
    		sol.add(d.get(i).sol);
    	}
        return sol;
    }
    
}
 
class Data{
	Double distance;
	List<Integer> sol;

	public String toString() {
		return "Data [distance=" + distance + ", sol=" + sol + "]";
	}
	
}
 public class Amz1{
	 public static void main(String args[]) {
		 List<List<Integer>> data = new ArrayList<>();
		 data.add(new ArrayList<Integer>() {{add(3); add(6);}});
		 data.add(new ArrayList<Integer>() {{add(2); add(4);}});
		 data.add(new ArrayList<Integer>() {{add(5); add(3);}});
		 data.add(new ArrayList<Integer>() {{add(2); add(7);}});
		 data.add(new ArrayList<Integer>() {{add(1); add(8);}});
		 data.add(new ArrayList<Integer>() {{add(7); add(9);}});
		 
		 System.out.print(new Solution1().ClosestXdestinations(6, data, 3));
	 }
 }