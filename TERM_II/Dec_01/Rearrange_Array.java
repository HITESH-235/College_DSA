// Rearrange Array
// Given an array of size n, each element lies in bw 0 to n-1
// rearrange elements of the array such that after changing; A[i] is A[A[i]]
// e.g. in [4,0,2,1,3]; A[0] <- A[A[0]]: A[0] = A[4] = 3;
// hence it becomes [3,4,2,0,1]

// Encoding Approach: (O(1) space):
// to avoid using original A[i] values after modification we store both
// - old value = A[i]%n
// - new value = A[i]/n
// use formula A[i] = oldVal + newVal*n (oldVal = A[i]; newVal = A[A[i]])
// since all values are <n; old val can be extracted using % safely
// after encoding; decode all values by (e/n) each element (A[i] = A[i]/n)

package College_DSA.TERM_II.Dec_01;
import java.util.*;
public class Rearrange_Array {

    public void rearrangeArr_BF(ArrayList<Integer> A) {
        int n = A.size();
        int[] B = new int[n]; // temporary array
        for (int i=0; i<n; i++) {
            B[i] = A.get(A.get(i));
        }
        for (int i=0; i<n; i++) { // copying values back to A
            A.set(i, B[i]);
        }
    }

    public void rearrangeArr_Enc(ArrayList<Integer> A) {
        int n = A.size();

        // encode both old and new Vals into A[i]
        for (int i=0; i<n; i++) {
            int oldVal = A.get(i);
            int newVal = A.get(oldVal)%n;
            A.set(i, oldVal + newVal*n);
        }
        // decode by dividing each element by n
        for (int i=0; i<n; i++) {
            A.set(i, A.get(i)/n); // since A[i] = old + new*n
        }
    }
}
