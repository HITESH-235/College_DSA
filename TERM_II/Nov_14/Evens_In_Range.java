// Even Numbers in Range: Return the count of even numbers in given range

package College_DSA.TERM_II.Nov_14;
public class Evens_In_Range {

    public int[] evensInRange_BF(int[] A,int[][] B) {
        int m = B.length;
        int res[] = new int[m];

        for (int k=0; k<m; k++) {
            int l = B[k][0];
            int r = B[k][1];

            int count = 0;
            for (int i=l; i<=r; i++) {
                if (A[i]%2 == 0) count++;
            }
            res[k] = count;
        }
        return res;
    }

    public int[] evensInRange_Opt(int[] A, int[][] B) {
        int n = A.length, m = B.length;
        int prefix[] = new int[n+1];
        for (int i=1; i<=n; i++) {
            prefix[i] = prefix[i-1] + ((A[i-1]%2 == 0) ? 1:0);
        }

        int res[] = new int[m];
        int i=0;
        for (int curr[]: B) {
            int l = curr[0]; 
            int r = curr[1];
            res[i++] = prefix[r+1]-prefix[l];
        }
        return res;
    }
    
    // Sum of odd index elements in given range
    public int[] sumOfOddsInRange_BF(int[] A, int[][] B) {
        int m = B.length;
        int res[] = new int[m];

        for (int k=0; k<m; k++) {
            int l = B[k][0];
            int r = B[k][1];

            int oddSum = 0;
            for (int i=l; i<=r; i++) {
                if (i%2 == 1) oddSum += A[i];
            }
            res[k] = oddSum;
        }
        return res;
    }

    public int[] sumOfOddsInRange_Opt(int[] A, int[][] B) {
        int n = A.length, m = B.length;
        int prefix[] = new int[n+1];
        for (int i=1; i<=n; i++) {
            prefix[i] = prefix[i-1] + ((i%2 == 1)?A[i-1]:0);
        }

        int res[] = new int[m];
        int i=0;
        for (int curr[]: B) {
            int r = curr[1]; 
            int l = curr[0]; 
            res[i++] = prefix[r+1]-prefix[l];
        }
        return res;
    }
}
