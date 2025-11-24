// Pick From Both Sides
// Link: https://www.scaler.com/academy/mentee-dashboard/class/469981/assignment/problems/9900?navref=cl_tt_crd_nm

// Question:
// given an arr A of size N on which we have to perform B operations
// In 1 oper., we can remove either the leftmost or rightmost element of Arr
// return the maximum possible sum of B elements that were removed after B operations
// Suppose B = 3 and A has 10 elements: we have 4 possibilities:
// remove 3 elements from A and 0 element from B or vice versa
// remove 2 elements from A and 1 element from B or vice versa

package College_DSA.TERM_II.Nov_14;
public class Both_Side_Picks {
    
    public int bothSidePicks_BF(int[] A, int B) {
        int res = Integer.MIN_VALUE;
        int n = A.length;
        for (int i=0; i<=B; i++) {
            int curr = 0;
            for (int j=0; j<i; j++) {
                curr += A[j];
            }
            for (int j=n-1; j>=n-(B-i); j--) {
                curr += A[j];
            }
            res = Math.max(res,curr);
        }
        return res;
    }

    public int bothSidePicks_Opt(int[] A, int B) {
        int n = A.length;
        int[] prefix = new int[B+1];
        int[] suffix = new int[B+1];

        for (int i=0; i<B; i++) {
            prefix[i+1] = prefix[i] + A[i];
            suffix[i+1] = suffix[i] + A[n-i-1];
        }

        int res = Integer.MIN_VALUE;
        for (int i=0; i<=B; i++) {
            res = Math.max(res,prefix[i]+suffix[B-i]);
        }
        return res;
    } 
}
