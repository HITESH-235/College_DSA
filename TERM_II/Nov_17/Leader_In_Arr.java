// Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
// An element is a leader if it is strictly greater than all the elements to its right side.

package College_DSA.TERM_II.Nov_17;
import java.util.*;
public class Leader_In_Arr {

    public int[] leaderInArr_BF(int[] A) {
        int n = A.length;
        List<Integer> res = new ArrayList<>();

        for (int i=n-1; i>=0; i--) {
            boolean flag = true;
            for (int j=0; j<i; j++) {
                if (A[j] > A[i]) flag = false;
            }
            if (flag) res.add(A[i]);
        }

        int res2[] = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            res2[i] = res.get(i);
        }
        return res2;
    }

    public int[] leaderInArr_Opt(int[] A) {
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();

        for (int i=A.length-1; i>=0; i--) {
            if (max<A[i]) {
                res.add(A[i]);
                max = A[i];
            }
        }
        int[] res2 = new int[res.size()];

        for (int i=0; i<res.size(); i++) {
            res2[i] = res.get(i);
        }
        return res2;
    }
}