package College_DSA.TERM_II.Nov_19;

public class Max_SubArr_Sum {

    // Maximum Subarray Sum Of Length B:

    public long maxSubarrLenB(int[] A, int B) {
        int n = A.length;
        long curr = 0;
        for (int i=0; i<B; i++) {
            curr += A[i];
        }
        long res = curr;
        for (int i=B; i<n; i++) {
            curr += A[i]-A[i-B];
            res = Math.max(curr,res);
        }
        return res;
    }

    // Maximum Subarray Sum Possible:

    // Brute Force: O(N^2); O(1)
    public int maxSubArrSum_BF(int[] A) {
        int n = A.length;
        int res = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += A[j];
            }
            res = Math.max(sum,res);
        }
        return res;
    }
    // Kadanes Algo: O(N); O(1)
    public int maxSubArrSum_Kds(int[] A) {
        int total = 0;
        int res = Integer.MIN_VALUE;
        for (int e: A) {
            total += e;
            res = Math.max(res,total);
            if (total < 0) total = 0;
        }
        return res;
    }
    // DP sol: TC: O(N); O(1)
    public int maxSubArrSum_DP(int[] A) {
        int total = 0;
        int res = Integer.MIN_VALUE;
        for (int e: A) {
            total = Math.max(e,total+e);
            res = Math.max(res,total);
        }
        return res;
    }
}
