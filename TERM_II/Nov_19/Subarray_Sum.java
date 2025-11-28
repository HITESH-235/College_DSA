/* Sum of All Subarray Sums:
LINK: https://www.scaler.com/academy/mentee-dashboard/class/470379/assignment/problems/14363?navref=cl_tt_nv */

package College_DSA.TERM_II.Nov_19;
public class Subarray_Sum {
    
    public long subArraySum_BF(int[] A) {
        long res =0;
        int n = A.length;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                for (int k=i; k<=j; k++) {
                    res += A[k];
                }
            }
        }
        return res;
    }

    public long subArraySum_Prefix(int[] A) {
        int n = A.length;
        int[] prefix = new int[n+1];
        for (int i=0; i<n; i++) {
            prefix[i+1] = prefix[i] + A[i];
        }
        long res = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                res += prefix[j+1] - prefix[i];
            }
        }
        return res;
    }

    public long subarraySum_Opt(int[] A) {
        long res = 0;
        int n = A.length;
        for (int i=0; i<n; i++) {
            long temp = (long) A[i]*(n-i)*(i+1);
            res += temp;
        }
        return res;
    }
}
