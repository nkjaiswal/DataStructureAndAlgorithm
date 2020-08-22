// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Amz2
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int min = 999999;
    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
         min = 999999;
        
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numColumns; j++){
                switch (getValue(i,j,area)){
                    case 9:
                        setValue(i,j,area,-9);
                        break;
                    case 1:
                        setValue(i,j,area,0);
                        break;
                    case 0:
                        setValue(i,j,area,-1);
                        break;
                    default:
                        setValue(i,j,area,0);
                }
            }
        }
        // System.out.println(area);
        setValue(0,0,area,1);
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numColumns; j++){
                if(getValue(i,j,area)<=0)
                    continue;
                System.out.println(area);
                if(i-1>=0)
                setValue(i-1, j, area, getValue(i,j, area)+1);
                
                if(i+1<numRows)
                setValue(i+1, j, area, getValue(i,j, area)+1);
                
                if(j-1>=0)
                setValue(i, j-1, area, getValue(i,j,area)+1);
                
                if(j+1<numColumns)
                setValue(i, j+1, area, getValue(i,j,area)+1);
            }
        }
        // System.out.println(area);
        return min;
        // WRITE YOUR CODE HERE
    }
    
    private void setValue(int r, int c, List<List<Integer>> area, int val){
        
        Integer curr = area.get(r).get(c);
        if(curr < 0){
            if(curr == -9)
                min = Math.min(min, (val - 1));
            return;
        }else{
            if(getValue(r,c,area) == 0)
                area.get(r).set(c, val);
            else if(val < curr){
                area.get(r).set(c, val);
            }
        }
    }
    private Integer getValue(int r, int c, List<List<Integer>> area){
        return area.get(r).get(c);
    }
    // METHOD SIGNATURE ENDS
}