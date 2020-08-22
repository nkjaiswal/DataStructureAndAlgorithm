import java.util.HashMap;
import java.util.Map;

/**
 * Paint N house, with K color and M speciality
 * Speciality is 3 for RED, RED, BLUE, GREEN, GREEN, GREEN
 * Speciality is 4 for RED, RED, BLUE, GREEN, GREEN, RED
 * Given Cost Metrixs NxK
 */
public class PaintHouseWithGivenSpeciality {
    public static void main(String[] args) {
        int N = 8;
        int K = 4;
        int M = 4;
        int house[] = new int[N];
        house[0]=0; house[1]=0; house[2]=0; house[3]=0; house[4]=4; house[5]=0; house[6]=0; house[7]=1;
        int cost[][] = new int[N][K];
        cost[0][0] = 100;   cost[0][1] = 20;    cost[0][2] = 100;   cost[0][3] = 20;
        cost[1][0] = 30;    cost[1][1] = 59;    cost[1][2] = 30;    cost[1][3] = 59;
        cost[2][0] = 71;    cost[2][1] = 81;    cost[2][2] = 71;    cost[2][3] = 81;
        cost[3][0] = 9;     cost[3][1] = 200;   cost[3][2] = 9;     cost[3][3] = 200;

        cost[4][0] = 100;   cost[4][1] = 20;    cost[4][2] = 100;   cost[4][3] = 20;
        cost[5][0] = 30;    cost[5][1] = 59;    cost[5][2] = 30;    cost[5][3] = 59;
        cost[6][0] = 71;    cost[6][1] = 81;    cost[6][2] = 71;    cost[6][3] = 81;
        cost[7][0] = 9;     cost[7][1] = 200;   cost[7][2] = 9;     cost[7][3] = 200;
        System.out.println(new PaintHouseWithGivenSpeciality().solve(N, K, M, cost, house));
    }

    private int solve(int n, int k, int m, int[][] cost, int[] house) {
        int spec = this.findCurrentSpeciality(house);
        if(m < spec || m <= 0) {// already more color are used so can not achieve given speciality.
            return -1;
        }

        if(m == spec) {// Already of given speciality
            return getMinimumCostForCurrentPaintedSpeciality(house, cost);
        }

        // m > spec
        if(house[0] == 0) {
            int min = Integer.MAX_VALUE;
            for(int i=0; i<k; i++) {
                house[0] = i+1;
                min= Math.min(min, paintHouse(cost, house, m, 0, cost[0][i], k));
                house[0] = 0;
            }
            return min;
        } else {
            return paintHouse(cost, house, m, 0, 0, k);
        }
    }

    private int paintHouse(int[][] cost, int[] house, int m, int index, int sum, int colors) {
        if(m <= 0){
            return Integer.MAX_VALUE;
        }
        if (index == house.length-1 && m == 1){
            return sum;
        }
        if (index == house.length-1 && m >1) {
            return Integer.MAX_VALUE;
        }
        if(house[index+1] == 0){ //Not Painted
            int min = Integer.MAX_VALUE;
            for (int i=0; i<colors; i++) {
                house[index+1] = i+1;
                if (i+1 == house[index]) { //same color as current house
                    min = Math.min(min, paintHouse(cost, house, m, index+1, sum + cost[index+1][i], colors));
                } else { //different color
                    min = Math.min(min, paintHouse(cost, house, m-1, index+1, sum + cost[index+1][i], colors));
                }
                house[index+1] = 0;
            }
            return min;
        } else { // painted
            if (house[index] == house[index+1]) { //same color
                int costTemp = paintHouse(cost, house, m, index+1, sum, colors);;
                return costTemp;
            } else {    //different color
                int costTemp = paintHouse(cost, house, m-1, index+1, sum, colors);
                return costTemp;
            }
        }
    }

    private int getMinimumCostForCurrentPaintedSpeciality(int[] house, int[][] cost) {
        int sum = 0;
        int left = -1, right = -1;
        for(int i=0; i<house.length; i++) {
            if(house[i] == 0 && left == -1){
                left = i;
            }
            if(house[i] == 0){
                right = i;
            }
            if(house[i] !=0){
                if(left >= 0 && right >= left){
                    if (left == 0)
                        sum += paintCost(left, right, cost, house[right+1]);
                    else if (right == house.length-1)
                        sum += paintCost(left, right, cost, house[left-1]);
                    else
                        sum += Math.min(paintCost(left, right, cost, house[left-1]), paintCost(left, right, cost, house[right+1]));
                }
                left = -1;
                right = -1;
            }
        }
        return sum;
    }

    private int paintCost(int from, int till, int[][] cost, int color) {
        int paintCost = 0;
        for(int i=from; i<=till; i++) {
            paintCost += cost[i][color-1];
        }
        return paintCost;
    }

    private int findCurrentSpeciality(int[] house) {
        int color = house[0];
        int spec = house[0] == 0? 0: 1;
        for (int i=1; i<house.length; i++) {
            if(house[i]!=0){
                if(color != house[i]){
                    color = house[i];
                    spec++;
                }
            }
        }
        return spec;
    }
}
