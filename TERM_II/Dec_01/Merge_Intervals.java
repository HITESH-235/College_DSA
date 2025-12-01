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
        Stack<int[]> st = new Stack<>();
        Arrays.sort(A, (a,b) -> Integer.compare(a[0],b[0]));
        
        st.push(A[0]);
        for (int i=0; i<A.length; i++) {
            if (st.peek()[1] > A[i][0]) {
                st.peek()[1] = Math.max(st.peek()[1], A[i][1]);
            }
            else {
                st.push(A[i]);
            }
        }
        int[][] res = new int[st.size()][2];
        int i=st.size()-1;
        while (!st.isEmpty()) {
            res[i--] = st.pop();
        }
        return res;
    }
}
