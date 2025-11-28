// You are given an array A of integers of size N.
// Your task is to find the equilibrium index of the given array
// The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
// If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

package College_DSA.TERM_II.Nov_17;
public class Equilibrium_Index {
    public int equilibriumIndex_BF(int[] A) {
        int n = A.length;
        for (int i=0; i<n; i++) {
            int left = 0;
            for (int j=0; j<i; j++) {
                left += A[j];
            }

            int right = 0;
            for (int j=i+1; j<n; j++) {
                right += A[j];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    public int equilibriumIndex_Opt(int[] A) {
        int total = 0;
        for (int e: A) {
            total += e;
        }
        int left_sum = 0;
        for (int i=0; i<A.length; i++) {
            total -= A[i];
            if (total == left_sum) {return i;}
            left_sum += A[i];
        }
        return -1;
    }
}
