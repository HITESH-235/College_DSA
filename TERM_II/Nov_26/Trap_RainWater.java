package College_DSA.TERM_II.Nov_26;
public class Trap_RainWater {

    public int trapRainWater_BF(final int[] A) {
        int n = A.length;
        int res = 0;

        for (int i=0; i<n; i++) {
            int leftMax = A[i];
            for (int l=i-1; l>=0; l--) {
                leftMax = Math.max(leftMax, A[l]);
            }

            int rightMax = A[i];
            for (int r=i+1; r<n; r++) {
                rightMax = Math.max(rightMax, A[r]);
            }

            res += Math.min(leftMax, rightMax) - A[i];
        }
        return res;
    }

    public int trapRainWater_TP(final int[] A) {
        int n = A.length;
        int l = 0, r = n-1;
        int lm = 0, rm = 0;

        int res = 0;
        while (l<r) {
            lm = Math.max(lm,A[l]);
            rm = Math.max(rm,A[r]);

            if (lm < rm) {
                res += lm - A[l++];
            }
            else {
                res += rm - A[r--];
            }
        } 
        return res;
    }
}