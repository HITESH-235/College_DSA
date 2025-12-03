// # Longest Palindromic Substring: return the largest palindromic (in sequence) substring from given string
// LEETCODE link: https://leetcode.com/problems/longest-palindromic-substring/description/

package College_DSA.TERM_II.Dec_03;
public class Longest_Palindrome {

    public String longestPalindrome_BF(String s) {
        int n = s.length();
        int[] pair = new int[2]; 

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (checkPalindrome(s, i, j) && pair[1]-pair[0] < j-i) {
                    pair[0] = i;
                    pair[1] = j;
                }
            }
        }
        return s.substring(pair[0],pair[1]+1);
    }

    public boolean checkPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int[] pair = new int[2]; 
        int l, r;

        for (int i=0; i<n; i++) {
            int[] oddRange = expand(i,i,s);
            l = oddRange[0];
            r = oddRange[1];
            
            if (pair[1]-pair[0]+1 < r-l+1) {
                pair[0] = l;
                pair[1] = r;
            }
            
            int[] evenRange = expand(i,i+1,s);
            l = evenRange[0];
            r = evenRange[1];

            if (pair[1]-pair[0]+1 < r-l+1) {
                pair[0] = l;
                pair[1] = r;
            }
            
        }   
        return s.substring(pair[0],pair[1]+1);
    }

    public int[] expand(int l, int r, String s) {
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[]{l+1,r-1};
    }
}