// Link: https://www.scaler.com/academy/mentee-dashboard/class/459761/assignment/problems/29028?navref=cl_tt_nv
// Count Factors of given num 'A'

package College_DSA.TERM_II.Oct_29;
public class Count_Factors {
    
    public static int countFactors_BF(int A) {
        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (A % i == 0) {
                count++;
            }
        }
        return count;
    }

    public int countFactors_Opt(int A) {
        int count = 0;
        for (int i=1; i*i<=A; i++) {
            if (A%i == 0) {
                if (A/i != i) count+=2;
                else count++;
            }
        }
        return count;
    }
}
