// Given an array of integers A and an integer B
// return the minimum number of swaps required to bring all the numbers less than or equal to B together.
// it is possible to swap any two elements, not necessarily consecutive

package College_DSA.TERM_II.Nov_19;

public class Min_Swaps {
    public int minSwaps_BF(int[] A, int B) {
        int n = A.length;
        int count = 0; // numbers less than eq to B

        for (int e: A) {
            if (e <= B) count++;  
        }
        int res = count;
        for (int i=0; i<n-count; i++) {
            int bad = 0;
            for (int j=i; j<count; j++) {
                if (A[j] > B) bad++;
            }
            res = Math.min(res, bad);
        }
        return res;
    }

    public int minSwaps_SW(int[] A, int B) {
        int n = A.length;
        int count = 0;
        for (int e: A) {
            if (e<=B) count++;
        }
        int bad = 0;
        for (int i=0; i<count; i++) {
            if (A[i] > B) bad++;
        }
        int res = bad;
        for (int i=count; i<n; i++) {
            if (A[i-count] > B) bad--;
            if (A[i]>B) bad++;
            res = Math.min(res,bad);
        }
        return res;
    }
}