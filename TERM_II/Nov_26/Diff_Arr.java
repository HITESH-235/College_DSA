/* Perform operations on the given arr and return the new ArrayList formed
each operation is of form (l,r,e) where l to r is the range where operation is performed
increase the value of the array by exactly e for every index in this array
GeeksForGeeks link: https://www.geeksforgeeks.org/problems/difference-array/1 */

package College_DSA.TERM_II.Nov_26;
import java.util.*;
public class Diff_Arr {

    // Brute Force : O(N^2); O(1)
    public ArrayList<Integer> diffArray_BF(int[] arr, int[][] opr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int e: arr) {
            res.add(e);
        }

        for (int[] curr: opr) {
            int l = curr[0], r = curr[1], e = curr[2];
            for (int i=l; i<=r; i++) {
                res.set(i,res.get(i)+e);
            }
        }
        return res;
    }

    // Optimised DIFF ARRAY METHOD: O(N); O(N)
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {
        int n = arr.length;
        int[] diff = new int[n+1];
        
        for (int[] curr: opr) {
            int l = curr[0], r = curr[1], e = curr[2];
            diff[l] += e;
            diff[r+1] -= e;
        }

        ArrayList<Integer> res = new ArrayList<>();
        int running = 0;

        for (int i=0; i<n; i++) {
            running += diff[i];
            res.add(arr[i] + running);
        }
        return res;
    }   
}
