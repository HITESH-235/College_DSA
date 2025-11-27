// 1. input(): 
// This method reads input from the user to populate the entire array. 
// Each row is entered on a new line, and elements within a row are space-separated.

// 2. multiply(Matrix): 
// This method returns the product of two matrices, assuming they can be multiplied.

// 3. diagonalDifference(): 
// This method calculates and returns the abs diff b/w the sum of the diagonal and the sum of the Anti-diagonal. 
// If the diagonal does not exist (e.g., in a non-square matrix), return -1.

// 4. print(): This method prints the entire matrix column by column. 
// Each column is displayed on a new line, and values within each column are separated by a single space.

package College_DSA.TERM_II.OOPS.OOPS_3;
import java.util.*;
public class Matrix2 {

    int row, col;
    int matrix[][];
	Matrix2(int r, int c) {
        this.row = r;
        this.col = c;
        matrix = new int[r][c];
    }

    public void input(Scanner sc) {
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    public Matrix2 multiply(Matrix2 other) {
        Matrix2 res = new Matrix2(row, other.col);

        for (int i=0; i<row; i++) {
            for (int j=0; j<other.col; j++) {
                for (int k=0; k<col; k++) {
                    res.matrix[i][j] += matrix[i][k]*other.matrix[k][j];
                }
            }
        }
        return res;
    }

    public int diagonalDifference() {
        if (row != col) return -1;

        int diag = 0,anti = 0;
        for (int i=0; i<row; i++) {
            diag += matrix[i][i];
            anti += matrix[i][row-i-1];
        }
        return Math.abs(diag - anti);
    }

    public void print() {
        for (int i=0; i<col; i++) {
            for (int j=0; j<row; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}
