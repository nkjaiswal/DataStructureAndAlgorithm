/*

1 2 3 X
4 5 6 Y
7 8 9 Z

7 4 1
8 5 2
9 6 3
Z Y X


1 2 3
4 5 6

4 1
5 2
6 3
 */

public class Oracle3 {
    public static void main(String[] args) {
        char[][] data = {
                {'a','b','c','d','e'},
                {'f','g','h','i','j'},
                {'k','l','m','n','o'},
                {'p','q','r','s','t'}
        };
        char[][] mat = new Oracle3().getRotatedMatrix(data, 4, 5);
        for(int i=0; i<5; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    //1 2
    //3 4

    //3 1
    //4 2
    //first row => last col
    public char[][] getRotatedMatrix(char[][] matrix, int row, int col) {
        char[][] rotatedMatrix = new char[col][row];
        for(int i=0; i<row; i++) { //i=0
            for(int j=0; j<col; j++) {
                System.out.println(j + "_" + (col-i-1));
                rotatedMatrix[j][row-i-1] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    public char[][] getRotatedMatrixinPlace(char[][] matrix) {
        int n = matrix.length;

        for(int i=0; i<n; i++) { //i=0
            for(int j=0; j<n; j++) {


            }
        }
        return matrix;
    }
}

//i=2, j=2, 11