/* Insert Interval:
given an array A of "non-overlapping intervals" only, and an extra interval B
insert this new interval into A such that the boundaries still remain non overlapping
leetcode question has A sorted and boundaries non overlapping
geeks for geeks does not guarantee both constrain hence second sol is for */

/* Insert interval (sorted already) optimal solution:
- all the intervals that come completely before B, whose start cannot overlap with B
add them directly to the result (A[i].end < B.start)
- merge all intervals that do overlap with B, start expanding B to include them
all intervals with "A[i].start <= B.end" need to be absorbed by B
- B.start = min(B.start, A[i].start) & B.end = max(B.end, A[i].end), and aftert this
append B to res after the condition is false
- all remaining elements again do not overlap with B hence add directly to res */

/* Insert interval (unsorted, overlapping intervals):
- first just add B to A without any conditions
use Collections.sort(A, (a,b) -> Integer.compare(a.start, b.start)) for arraylist
use Arrays.sort(A, (a,b) -> Integer.compare(a.start, b.start)) for primitive arr
- use stack method to merge intervals comparing st[-1].end and A[i].start */

package College_DSA.TERM_II.Dec_01;
import java.util.*;
public class Insert_Interval {
    public List<List<Integer>> insertInterval_Sorted(int[][] A, int[] B) {
        int n = A.length;
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (i<n && A[i][0] < B[0]) {
            res.add(Arrays.asList(A[i][0], A[i][1]));
            i++;
        }
        
        while (i<n && A[i][0] <= B[1]) {
            B[0] = Math.min(B[0], A[i][0]);
            B[1] = Math.max(B[0], A[i][1]);
            i++;
        }
        res.add(Arrays.asList(B[0], B[1]));

        while (i<n) {
            res.add(Arrays.asList(A[i][0], A[i][1]));
        }
        return res;
    }

    public List<List<Integer>> insertInterval_Unsorted(int[][] A, int[] B) {
        List<int[]> temp = new ArrayList<>();
        
        for (int[] interval: A) {
            temp.add(interval);
        }
        temp.add(B);
        temp.sort((a,b) -> Integer.compare(a[0],b[0]));

        List<List<Integer>> res = new ArrayList<>();
        int[] prev = temp.get(0);
        
        for (int i=1; i<temp.size(); i++) {
            int[] curr = temp.get(1);

            if (prev[1] > curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            }
            else {
                res.add(Arrays.asList(prev[0], prev[1]));
                prev = curr;
            }
        }
        res.add(Arrays.asList(prev[0], prev[1]));
        return res;
    }
}