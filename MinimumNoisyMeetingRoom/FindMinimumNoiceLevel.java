package MinimumNoisyMeetingRoom;

/**
 * @author NishantKumar
 * Given Grid of NxM, each cell presenting 1 meeting room.
 * More meeting room are adjucent and busy more noice.
 * Find the Minimum Noice level given no of meeting need to be conducted.
 * Example, 3x3 = 9 meeting room and 8 meeting need to happen
 * Arrangement could be many
 *  X X X      X X X
 *  X X X      X 0 X
 *  X X 0      X X X
 *  In first arrangement Noice level is 10 because 10 common edge between busy meeting room
 *  In Secod it is 7, so 7 is our optimal Solution
 */
public class FindMinimumNoiceLevel {

    public static void main(String[] args) {
        new FindMinimumNoiceLevel().find(13, 2,7);
    }

    public void find(int noOfMeeting, int rowCount, int columnCount){
        int initialCellNo = 0;
        int initialCost = 0;
        int[][] rooms = new int[rowCount][columnCount];
        find(noOfMeeting, initialCellNo, initialCost, rowCount, columnCount, rooms);
        System.out.println(minCost);
    }

    int minCost = Integer.MAX_VALUE;

    private void find(int noOfMeeting, int cellNo, int cost,  int rowCount, int columnCount, int[][] rooms){
//        System.out.println(noOfMeeting + ", " + cellNo + ", " + cost);
        int MAX_CELL = rowCount * columnCount;

        if(noOfMeeting == 0){
            minCost = Math.min(minCost, cost);
            return;
        }

        if(cellNo >= MAX_CELL)
            return;


        int nextCell = cellNo+1;

        rooms[getRowNo(cellNo, rowCount, columnCount)][getColNo(cellNo, rowCount, columnCount)] = 1;
        int newCost = getCellNoiceLevel(cellNo, rooms, rowCount, columnCount) + cost;
        find(noOfMeeting-1, nextCell, newCost, rowCount,  columnCount, rooms);
        rooms[getRowNo(cellNo, rowCount, columnCount)][getColNo(cellNo, rowCount, columnCount)] = 0;

        find(noOfMeeting, nextCell, cost, rowCount, columnCount, rooms);

    }


    private int getCellNoiceLevel(int cellNo, int[][] rooms, int rowCount, int colCount){
        int noise = 0;
        if(isTopCellBusy(cellNo, rooms, rowCount, colCount))
            noise += 1;
        if(isLeftCellBusy(cellNo, rooms, rowCount, colCount))
            noise += 1;
        return noise;
    }

    private boolean isTopCellBusy(int cellNo, int[][] rooms, int rowCount, int columnCount){
        int row = getRowNo(cellNo, rowCount, columnCount);
        int col = getColNo(cellNo, rowCount, columnCount);
        if(row == 0)
            return false;
        return rooms[row-1][col] == 1;
    }
    private boolean isLeftCellBusy(int cellNo, int[][] rooms, int rowCount, int columnCount){
        int row = getRowNo(cellNo, rowCount, columnCount);
        int col = getColNo(cellNo, rowCount, columnCount);
        if(col == 0)
            return false;
        return rooms[row][col-1] == 1;
    }

    private int getRowNo(int cellNo, int rowCount, int colCount){
        return (cellNo/colCount);
    }

    private int getColNo(int cellNo, int rowCount, int colCount){
        return cellNo - (colCount * getRowNo(cellNo, rowCount, colCount));
    }
}
