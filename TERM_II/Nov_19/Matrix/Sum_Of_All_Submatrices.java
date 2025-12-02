package College_DSA.TERM_II.Nov_19.Matrix;
import java.util.*;
public class Sum_Of_All_Submatrices {

    public int sumSubMatrices_BF(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=i; k<n; k++) {
                    for (int l=j; l<m; l++) {
                        int temp = 0;
                        for (int x=i; x<=k; x++) {
                            for (int y=j; y<=l; y++) {
                                temp += A.get(x).get(y);
                            }
                        }
                        res += temp;
                    }
                }
            }
        }
        return res;
    }

    public int sumSubMatrices_Prefix(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        int[][] prefix = new int[n+1][m+1];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                prefix[i+1][j+1] = A.get(i).get(j) + prefix[i][j+1] + prefix[i+1][j] - prefix[i][j];
            }
        }
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=i; k<n; k++) {
                    for (int l=j; l<m; l++) {
                        res += prefix[k+1][l+1] - prefix[i][l+1] - prefix[k+1][j] + prefix[i][j];
                    }
                }
            }
        }
        return res;
    }

    public int sumSubMatrices_BF2(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int[] tempRowSum = new int[m];
 
                for (int k = i; k < n; k++) {

                    // accumulate row sum
                    int running = 0;
                    for (int l = j; l < m; l++) {
                        tempRowSum[l] += A.get(k).get(l);
                        running += tempRowSum[l];
                        res += running;
                    }
                }
            }
        }
        return res;
    }
}