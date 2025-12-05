package College_DSA.TERM_II.Dec_05;
import java.util.*;
public class Min_Window {

    public String minWindow_Arr(String s, String t) {
        int[] countT = new int[58];
        int[] window = new int[58];
        int have = 0, need = 0;

        for (char c: t.toCharArray()) {
            if (countT[c-'A'] == 0) need++;
            countT[c-'A']++;
        }

        int[] res = {-1,-1};
        int minLen = Integer.MAX_VALUE;
        int l = 0; // left pointer

        for (int r=0; r<s.length(); r++) { // right pointer
            char c = s.charAt(r);

            if (countT[c-'A'] != 0) {
                window[c-'A']++;
                if (window[c-'A'] == countT[c-'A']) have++;
            }
            
            while (have == need) {
                if (r-l+1 < minLen) {
                    res[0] = l;
                    res[1] = r;
                    minLen = (r-l+1);
                }
                char left = s.charAt(l);
                if (countT[left-'A'] > 0) {
                    window[left-'A']--;
                    if (window[left-'A'] < countT[left-'A']) have--;
                }
                l++;
            }
        }
        if (minLen != Integer.MAX_VALUE) return s.substring(res[0], res[1]+1);
        return "";
    }

    public String minWindow_Hash(String s, String t) {
        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for (char c: t.toCharArray()) {
            countT.put(c,countT.getOrDefault(c,0)+1);
        }
        int have = 0, need = countT.size();
        int[] res = {-1,-1};
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        for (int right=0; right<s.length(); right++) {
            char c = s.charAt(right);
            if (countT.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).equals(countT.get(c))) have++;
            }
            
            while (have == need) {
                if (right - left + 1 < minLen) {
                    res[0] = left;
                    res[1] = right;
                    minLen = (right -left +1);
                }
                char l = s.charAt(left);
                if (countT.containsKey(l)) {
                    window.put(l, window.get(l)-1);
                    if (window.get(l) < countT.get(l)) have--;
                }
                left++;
            }
        }
        if (minLen != Integer.MAX_VALUE) return s.substring(res[0], res[1]+1);
        return "";
    }
}