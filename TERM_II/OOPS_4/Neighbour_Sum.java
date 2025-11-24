// Link: https://www.scaler.com/academy/mentee-dashboard/class/469982/homework/problems/271526?navref=cl_tt_nv

// Given a grid(nxn) 2d array with elemnents from 0 to n2-1 in ascending order
// ind adjacentSum(int value) returns the sum of all four main directions adjacent cells
// int diagonalSum(int value) returns the sum of all four diagonal direction cells

// the main class does this with O(n2) TC as Brute Force (for adjacentSum & diagSum methods)
// the other class does this in O(1) by using extra linear space

package College_DSA.TERM_II.OOPS_4;
public class Neighbour_Sum {
    private int[][] grid;
    private int n;
    private int[][] deltaAdj = {{0,1},{1,0},{0,-1},{-1,0}};
    private int[][] deltaDiag = {{-1,-1},{-1,1},{1-1},{1,1}};

    Neighbour_Sum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        deltaAdj = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        deltaDiag = new int[][]{{1,1},{-1,1},{1,-1},{-1,-1}};
    }

    public int adjacentSum(int value) {
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    for (int k=0; k<4; k++) {
                        int r = i+deltaAdj[k][0];
                        int c = j+deltaAdj[k][1];

                        if (r<=0 || r>=n || c<0 || c>=n) continue;
                        else res  += grid[r][c];
                    }
                    break;
                }
            }
        }
        return res;
    }

    public int diagonalSum(int value) {
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == value) {
                    for (int k=0; k<4; k++) {
                        int r = i+deltaDiag[k][0];
                        int c = j+deltaDiag[k][1];

                        if (r<0 || r>=n || c<0 || c>=n) continue;
                        else res+=grid[r][c]; 
                    }
                    break;
                } 
            }
        }
        return res;
    }
}

class Neighbour_Sum_Opt {
    private int[][] grid;
    private int n;
    private int[][] deltaAdj = {{0,1},{1,0},{0,-1},{-1,0}};
    private int[][] deltaDiag = {{-1,-1},{-1,1},{1-1},{1,1}};
    private int[] temp;
    
    Neighbour_Sum_Opt(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        
        deltaAdj = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        deltaDiag = new int[][]{{1,1},{-1,1},{1,-1},{-1,-1}};

        temp = new int[n*n]; // can use n*n matrix temp as well
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                temp[grid[i][j]] = i*n + j;
            }
        }
    }
    
    public int adjacentSum(int value) {
        int res = 0;
        int i = temp[value]/n;
        int j = temp[value]%n;

        for (int k=0; k<4; k++) {
            int r = i+deltaAdj[k][0];
            int c = j+deltaAdj[k][1];

            if (r<0 || r>=n || c<0 || c>=n) continue;
            else res+=grid[r][c]; 
        }
        return res;
    }
    
    public int diagonalSum(int value) {
        int res = 0;
        int i = temp[value]/n;
        int j = temp[value]%n;

        for (int k=0; k<4; k++) {
            int r = i+deltaDiag[k][0];
            int c = j+deltaDiag[k][1];

            if (r<0 || r>=n || c<0 || c>=n) continue;
            else res+=grid[r][c]; 
        }
        return res;
    }

}