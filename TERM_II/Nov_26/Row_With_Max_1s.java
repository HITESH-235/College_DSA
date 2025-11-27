package College_DSA.TERM_II.Nov_26;
public class Row_With_Max_1s {
    
    public int rowWithMax1s_BF(int[][] A) {
        int res = 0, max1s = Integer.MIN_VALUE;
        int n = A.length;
        for (int i=0; i<n; i++) {
            int curr = 0;
            for (int e: A[i]) {
                curr += e;
            }
            if (max1s < curr) {
                res = i;
                max1s = curr;
            }
        }
        return res;
    }

    public int rowWithMax1s_LS(int[][] A) {
        int n = A.length, m = A[0].length;
        int r = 0, c = m-1;
        int res = -1;

        while (r<n && c>=0) {
            int curr = A[r][c];
            if (curr == 0) r++;
            else {
                c--;
                res = r;
            }
        }
        return res;
    }
}
