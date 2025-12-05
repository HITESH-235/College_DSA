package College_DSA.TERM_II.Dec_05;
public class Check_Anagram {
 
    public int solve(String A, String B) {
        if (A.length() != B.length()) return 0;
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for (char a: A.toCharArray()) {
            freqA[a-'a']++;
        }
        for (char b: B.toCharArray()) {
            freqB[b-'a']++;
        }
        for (int i=0; i<26; i++) {
            if (freqA[i] != freqB[i]) return 0;
        }
        return 1;
    }
}