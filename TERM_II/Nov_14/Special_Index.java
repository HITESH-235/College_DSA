// LINK: https://www.scaler.com/academy/mentee-dashboard/class/469981/assignment/problems/12828?navref=cl_tt_nv_dd

// Special Index
// given an arr[] of size N, find the count of indices such that;
// removing the element from these indices makes the sum of even and odd indexed elements equal
// e.g. A = [2,1,6,4]: res = 1; removing '1' A becomes [2,6,4], hence 2+4 = 6

package College_DSA.TERM_II.Nov_14;
public class Special_Index {
    
    int specialIndex_BF(int[] A) {
        int n = A.length;
        int res = 0;

        for (int i=0; i<n; i++) {
            boolean removed = false;
            int odd = 0, even = 0;

            for (int j=0; j<n; j++) {
                if (j==i) {
                    removed = true;
                    continue;
                }

                if (!removed) {
                    if (j%2 == 0) odd += A[j];
                    else even += A[j];
                }
                else {
                    if (j%2 == 0) even += A[j];
                    else odd += A[j];
                }
            }
            if (odd == even) res++;
        }
        return res;
    }

    int specialIndex_Opt(int[] A) {
        int n = A.length;
        int res = 0;

        int r_odd = 0, r_even = 0;
        int l_odd = 0, l_even = 0;

        for (int i=0; i<n; i++) {
            if (i%2 == 0) r_odd += A[i];
            else r_even += A[i];
        }

        for (int i=0; i<n; i++) {
            if (i%2 == 0) r_odd -= A[i];
            else r_even -= A[i];
            
            if (r_odd + l_even == r_even + l_odd) res++;

            if (i%2 == 0) l_odd += A[i];
            else l_even += A[i];
        }
        return res;
    }
}