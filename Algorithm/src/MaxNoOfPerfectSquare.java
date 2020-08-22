import java.util.Date;

public class MaxNoOfPerfectSquare {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(new MaxNoOfPerfectSquare().getMaxLevelOfPerfectSquare(253,255,0));
//        System.out.println(new Date().getTime() - d1.getTime());
    }

    public int getMaxLevelOfPerfectSquare(double start, double end, int c){
        if(start > end){
            return c;
        }
        if(start == end){
            while(Math.pow((int)Math.sqrt(start),2) == start){
                start = Math.floor(Math.sqrt(start));
                c++;
            }
            return c;
        }
        else
            return getMaxLevelOfPerfectSquare(Math.ceil(Math.sqrt(start)),Math.floor( Math.sqrt(end)), c+1);
    }
}
