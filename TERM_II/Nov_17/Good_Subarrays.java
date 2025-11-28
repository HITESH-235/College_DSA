// Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
// 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
// 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
// Your task is to find the count of good subarrays in A.

package College_DSA.TERM_II.Nov_17;
public class Good_Subarrays {

    public int goodSubarray_BF(int[] A, int B) {
        int n = A.length;
        int res = 0;
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += A[j]; // fixed: was A[i]

                // (j - i) % 2 == 0 -> length = j-i+1 is odd
                if ((j-i)%2 == 0) {
                    if (sum > B) res++; // odd length -> sum > B
                }
                else if (sum < B) res++; // even length -> sum < B
            }
        }
        return res;
    }

    public int goodSubarray_Prefix(int[] A, int B) {
        int n = A.length;
        int[] p_sum = new int[n+1];

        for (int i=0; i<n; i++) {
            p_sum[i+1] = p_sum[i] + A[i];
        }
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int sum = p_sum[j+1] - p_sum[i];

                if ((i-j)%2 == 0) {
                    if (sum>B) res++;
                }
                else {
                    if (sum<B) res++;
                }
            }
        }
        return res;
    }
}
