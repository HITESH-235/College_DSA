// Range Sum Query
// LEETCODE link: https://leetcode.com/problems/range-sum-query-immutable/

// e.g., [-2, 0, 3, -5, 2, -1], [0, 2], [2, 5], [0, 5]
// outpute: [1, -1, -3]

package College_DSA.TERM_II.Nov_14;
public class Range_Sum_Query {
    int[] nums;
    int[] prefix;

    public Range_Sum_Query(int[] nums) {
        this.nums = nums;
        this.prefix = new int[nums.length+1];

        for (int i=1; i<=nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
    }
    
    public int sumRange_Opt(int left, int right) {
        return prefix[right+1] - prefix[left];
    }

    public int sumRange_BF(int left, int right) {
        int res = 0;
        for (int i=left; i<right; i++) {
            res += nums[i];
        }
        return res;
    }

    // Class Question-Styled answer:
    public long[] solve_Opt(int[] A, int[][] B) {
        int n = A.length, m = B.length;
        long prefix[] = new long[n+1];
        for (int i=1; i<=n; i++) {
            prefix[i] = prefix[i-1] + A[i-1];
        }

        long res[] = new long[m];
        int i=0;
        for (int curr[]: B) {
            int r = curr[1]; 
            int l = curr[0]; 
            res[i++] = prefix[r+1]-prefix[l];
        }
        return res;
    }

    public long[] solve_BF(int[] A, int[][] B) {
        long[] res = new long[B.length];
        int ind = 0;
        for (int[] curr: B) {
            int left = curr[0];
            int right = curr[1];
            long sum = 0;
            for (int i=left; i<=right; i++) {
                sum += A[i];
            }
            res[ind++] = sum;
        }
        return res;
    }
}
