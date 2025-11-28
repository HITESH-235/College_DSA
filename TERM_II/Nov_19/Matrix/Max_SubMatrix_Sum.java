package College_DSA.TERM_II.Nov_19.Matrix;

public class Max_SubMatrix_Sum {
    public int maxSubMatrixSum(int A[][], int B) {
        int n = A.length;
        int p[][] = new int[n+1][n+1];

        for (int i=0; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                p[i][j] =   A[i-1][j-1] + 
                            p[i-1][j] + 
                            p[i][j-1] - 
                            p[i-1][j-1];
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i=B; i<=n; i++) {
            for (int j=B; j<=n; j++) {
                int total = p[i][j] - p[i-1][j] - p[i][j-1] + p[i-B][j-B];
                res = Math.max(total, res);
            }
        }
        return res;
    }
}