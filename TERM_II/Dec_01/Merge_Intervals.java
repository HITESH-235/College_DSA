package College_DSA.TERM_II.Dec_01;
import java.util.*;
public class Merge_Intervals {
    public static void main(String[] args) {
        int[][] A = {{1, 3}, {6, 9}, {2,3}, {0,9}, {-1,2}, {-9,-7}}; // res = [[-9, -7], [-1, 9]]

        Merge_Intervals obj = new Merge_Intervals();
        int[][] res = obj.mergeIntervals(A);
        System.out.println(Arrays.deepToString(res));
    }

    int[][] mergeIntervals(int[][] A) {
        // if already sorted remove this line:
        Arrays.sort(A, (a,b) -> Integer.compare(a[0],b[0]));
        
        List<int[]> temp = new ArrayList<>();
        int[] prev = A[0];

        for (int i=1; i<A.length; i++) {
            int[] curr = A[i];

            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            }
            else {
                temp.add(new int[]{prev[0], prev[1]});
                prev = curr;
            }
        }
        temp.add(prev);

        int[][] res = new int[temp.size()][2];
        int i = 0;
        while (i < temp.size()) {
            res[i] = temp.get(i++);
        }
        return res;
    }

    class Interval {
        int start, end;

        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> mergeInterval_Class(ArrayList<Interval> A) {
        ArrayList<Interval> res = new ArrayList<>();
        A.sort((a,b) -> Integer.compare(a.start,b.start));
        
        Interval prev = A.get(0);
        for (int i=1; i<A.size(); i++) {
            Interval curr = A.get(i);
            if (prev.end >= curr.end) {
                prev.end = Math.max(prev.end, curr.end);
            }
            else {
                res.add(new Interval(prev.start, prev.end));
                prev = curr;
            }
        }
        res.add(prev);
        return res;
    }
}