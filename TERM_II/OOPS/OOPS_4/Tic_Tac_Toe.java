// Link: https://www.scaler.com/academy/mentee-dashboard/class/469982/assignment/problems/271495?navref=cl_tt_crd_nm

// Design a Tic Tac Toe service for an n x n board.
// Implement the class:
// TicTacToe(int n) – initializes the board of size n.
// int move(int row, int col, int player) – player 1 (O) or 2 (X) places a mark at (row, col) and returns:
// 1 if Player 1 wins,
// 2 if Player 2 wins,
// 0 otherwise.

package College_DSA.TERM_II.OOPS.OOPS_4;
public class Tic_Tac_Toe {

    private int n;
    private int[] rows;
    private int[] cols;
    private int diag;
    private int antiDiag;

    public Tic_Tac_Toe(int n) { // n is board size
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
    }

    // player 1: +1(O); player 2: -1(X);
    public int move(int row, int col, int player) {
        int val = (player == 1) ? 1:-1;

        if (row == col) diag += val;
        if (row + col == n-1) antiDiag += val;

        if (Math.abs(rows[row]) == n || 
            Math.abs(cols[n]) == n || 
            Math.abs(diag) == n ||
            Math.abs(antiDiag) == n) {
            return player;
        }
        return 0; // none wins, continue
    }
}
