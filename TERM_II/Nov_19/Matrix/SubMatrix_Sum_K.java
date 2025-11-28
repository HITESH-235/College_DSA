/* Number of SubMatrices with sum equals Target
LEETCODE link: https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/description/

- given an integer matrix and a target value
- a submatrix is any contiguous rectangular region inside the matrix
find how many such submatrices have a total sum equal to target

/* Explanation:

    A. BRUTE FORCE:
- try every possible submatric defined by (i,j) to (k,l)
for each submatrix, explicitly sum its cell
________________________________________________________________________________________________________________________________
    B. 2D PREFIX SUM APPROACH:
- build a prefix matrix where P[i][j] = sum of rectangle (0,0)->(i-1,j-1)
calculate prefix sum at (i,j) with formula: (currM + topP + leftP - top_leftP)
        P[i+1][j+1] = Mat[i][j] + P[i][j+1] + P[i+1][j] - P[i][j]
the previous corner is subtracted because it was taken twice in top and left

- for each submatrix (i,j)->(k,l), compute sum in O(1) using prefix matrix:
        sum = P[k+1][l+1] - P[i][l+1] - P[k+1][j] + P[i][j] 
increase count(res) whenver sum == target; hence takes N^2 * M^2 complex.
________________________________________________________________________________________________________________________________
    C & D. PREFIX-SUM + HASH: (+ Row-Compression)
- build a similar prefix matrix but here we use it smartly
fix two boundaries: r1,r2, comput the prefixsum from (r1,c) to (r2,c) using:
        sum(at c) = P[r2][c] - P[r1][c]

- problem reduces to: count ways to get sum 'target' until c b/w r1 and r2
which now uses a similar technique in Subarrays with sum equal to K
create a hashmap for every unique r1,r2 pair which stores
previous prefix sums received in previous values of c, look for (sum - target)

- reason why we search freq of (sum-target) occuring in prefix sum earlier;
is because the number of times (sum-target) is removed from sum, we get target
and even though we imagine it being removed, it is always contiguous

- now add this freq of (sum-target)'s available in map to count(res)
this can be further optimised as we can just compress each column instead 
of maintaining a full 2d prefix matrix - accumulating col wise sums on the fly
gives the same effect but reduce space from O(N*M) to O(M)
    colPSum[c] += Mat[r2][c]   (r2 varies from r1 to n)
    prefix += colPSum[c]  (accumulates sum from previous rows as well)

- colPSum[] is unique for values of r2 : (r1,r1) -> (r1,r1+1)... -> (r1,n)
rest updation is done for each value of c, while prefix var accumulates rows
______________________________________________________________________________________________________________________________*/
package College_DSA.TERM_II.Nov_19.Matrix;
import java.util.*;
public class SubMatrix_Sum_K {

    // A. BRUTE FORCE: O(N^3 * M^3); O(1)
    public int subMatrixSumK_BF(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int res = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=i; k<n; k++) {
                    for (int l=j; l<m; l++) {

                        int sum = 0;
                        for (int x=i; x<=k; x++) {
                            for (int y=j; y<=l; y++) {
                                sum += matrix[x][y];
                            }
                        }
                        if (sum == target) res++;
                    }
                }
            }
        }
        return res;
    }
    
    // B. PREFIX SUM: O(N^2 * M^2); O(N*M)
    public int subMatrixSumK_Prefix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int res = 0;
        int[][] prefix = new int[n+1][m+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                prefix[i+1][j+1] = matrix[i][j] + prefix[i+1][j] + prefix[i][j+1] - prefix[i][j];
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=i; k<n; k++) {
                    for (int l=j; l<m; l++) {
                        int sum = prefix[k+1][l+1] - prefix[i][l+1] - prefix[k+1][j] + prefix[i][j];
                        if (sum == target) res++;
                    }
                }
            }
        }
        return res;
    }

    // C.PREFIX SUM + HASH: O(N^2 * M); SC: O(N*M)
    public int subMatrixSumK_Hash(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int prefix[][] = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                prefix[i][j] = matrix[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];      
            }
        }
        int res = 0;
        for (int r1=0; r1<n; r1++) {
            for (int r2=r1+1; r2<=n; r2++) {
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                
                for (int c=1; c<=m; c++) {
                    int curSum = prefix[r2][c] - prefix[r1][c];

                    res += map.getOrDefault(curSum-target, 0);
                    map.put(curSum, map.getOrDefault(curSum, 0)+1);
                }
            }
        }
        return res;
    }

    // D.PREFIX-SUM + HASH (Less Space): O(N^2 * M); O(M)
    public int subMatrixSumK_Hash_2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int res = 0;
        for (int r1=0; r1<n; r1++) {
            int colPSum[] = new int[m];
            for (int r2=r1; r2<n; r2++) {
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int prefix = 0;

                for (int c=0; c<m; c++) {
                    colPSum[c] += matrix[r2][c];
                    prefix += colPSum[c];

                    res += map.getOrDefault(prefix - target, 0);
                    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
                }
            }
        }
        return res;
    }
}
