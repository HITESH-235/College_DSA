/* Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
It is allowed to swap any two elements (not necessarily consecutive).
Find the "Minimum Number of Swaps" required to sort the array in ascending order. */

package College_DSA.TERM_II.Nov_19;
public class Cyclic_Sort {

    // BruteForce: For every index i, if A[i] != i, find the correct element and swap
    public int cyclicSort_BF(int[] A) {
        int n = A.length;
        int res = 0;

        for (int i = 0; i < n; i++) {

            if (A[i] != i) { // If the element is not in the correct position

                // Find where the correct element i is located
                int correctIndex = -1;
                for (int j = i + 1; j < n; j++) {
                    if (A[j] == i) {
                        correctIndex = j;
                        break;
                    }
                }
                // bring element to its correct index
                swap(A, i, correctIndex);
                res++;
            }
        }
        return res;
    }
    
    // Optimised: Each swap fixes one element: total swaps = res
    public int cyclicSort(int[] A) {
        int res = 0;
        int i = 0, n = A.length;
        while (i<n) {
            int correct = A[i]; // correct index of A[i]
            // if element at i is not at correct position, keep swapping, till so
            if (correct<n && A[correct] != A[i]) {
                swap(A,i,correct);
                res++;
            }
            else { // dont move i unless element is found at correct index
                i++;
            }
        }
        return res;
    }

    void swap(int A[], int first, int second) {
        int temp = A[first];
        A[first] = A[second];
        A[second] = temp; 
    }
}
