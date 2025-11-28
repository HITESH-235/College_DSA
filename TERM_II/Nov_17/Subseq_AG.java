// You have given a string A having Uppercase English letters.
// You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.

package College_DSA.TERM_II.Nov_17;
public class Subseq_AG {

    public long subseqAG_BF(String A) {
        long res = 0;
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) == 'G') {
                long countA = 0;
                for (int j=0; j<i; j++) {
                    if (A.charAt(i) == 'A') countA++;
                }
                res += countA;
            }
        }
        return res;
    }

    public long subseqAG_Prefix(String A) {
        long count = 0, res = 0;
        for (char c: A.toCharArray()) {
            if (c=='A') {
                count++;
            }
            if (c=='G') {
                res += count;
            }
        }
        return res;
    }
}