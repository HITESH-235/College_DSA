// Find the subarray of length B with least average possible
// Hence just find subarray with least sum
// Return the first index of the req subarray

package College_DSA.TERM_II.Nov_17;
public class Subarr_Least_Avg {
    
    public int SubarrLeastAvg(int[] A, int B) {
        long sum = 0;
        for (int i=0; i<B; i++) {
            sum += A[i];
        }
        int res = 0;
        long min = sum;
        for (int i=B; i<A.length; i++) {
            sum += A[i] - A[i-B];
            if (min>sum) {
                min = sum;
                res = i-B+1;
            }
        }
        return res;
    }
}
