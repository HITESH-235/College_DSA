// You are given two strings, A and B, of size N and M, respectively.
// You have to find the count of all permutations of A present in B as a substring. 

package College_DSA.TERM_II.Dec_05;
public class Permutation_AB {

    public int solve(String A, String B) {
        int N = A.length();
        int M = B.length();

        int[] freqA = new int[26];
        int[] freqB = new int[26];
        
        for (int i = 0; i < N; i++) {
            freqA[A.charAt(i) - 'a']++;
            freqB[B.charAt(i) - 'a']++;
        }
        int count = 0;
        if (matches(freqA, freqB)) count++;

        for (int i = N; i < M; i++) {
            freqB[B.charAt(i) - 'a']++;
            freqB[B.charAt(i - N) - 'a']--;

            if (matches(freqA, freqB)) count++;
        }
        return count;
    }

    private boolean matches(int[] freqA, int[] freqB) {
        for (int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) return false;
        }
        return true;
    }
}