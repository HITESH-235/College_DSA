package College_DSA.TERM_II.Nov_14;

public class SubArr_Less_than_B {
    // No further optimisation possible
    public int subArrSumLessThanB(int[] A, int B) {
        int sum, count = 0;
        int n = A.length;
        for (int i=0; i<n; i++) {
            sum = 0;
            for (int j=i; j<n; j++) {
                sum += A[j];
                if (sum<B) count++;
                else break;
            }
        }
        return count;
    }
}
