/* given an integer N, representing the size of an array.
You are also given Q queries, where each query consists of two integers:
index – the starting position
value – the amount to be added
begin with an array of size N, filled with zeros: */

package College_DSA.TERM_II.Nov_26;
import java.util.*;
public class Range_Add_Queries {
    public static void main(String[] args) {
        Range_Add_Queries obj = new Range_Add_Queries();

        int n = 7;
        int[][] Q = {
            {1, 3},
            {4, -2},
            {3, 1}
        };

        int[] res = obj.rangeAddQueries_Opt(n, Q);
        System.out.print(Arrays.toString(res));
    }

    // Quadratic
    public int[] rangeAddQueries_BF(int n, int[][] Q) {
        int[] res = new int[n];

        for (int curr[]: Q) {
            for (int i=curr[0]; i<n; i++) {
                res[i] += curr[1];
            }
        }
        return res;
    }

    // Linear
    public int[] rangeAddQueries_Opt(int n, int[][] Q) {
        int[] res = new int[n];

        for (int curr[]: Q) {
            res[curr[0]] += curr[1];
        }
        for (int i=1; i<n; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}
