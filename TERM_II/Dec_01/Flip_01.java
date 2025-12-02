// Flip 01s
// given a string with only 0s and 1s
// pick any subarray of range (l+1,r+1) (1-indexed) and flip all the values
// such that the string contains maximum number of 1s after doing so

package College_DSA.TERM_II.Dec_01;
import java.util.*;
public class Flip_01 {

    public ArrayList<Integer> flip01_BF(String A) {
        int n = A.length();
        int maxGain = 0;
        int r = -1, l = -1;
        for (int i=0; i<n; i++) {
            int gain = 0;
            for (int j=i; j<n; j++) {
                if (A.charAt(j) == '0') gain++;
                else gain--;
                if (maxGain < gain) {
                    l = i;
                    r = j;
                    maxGain = gain;
                }
            }
        }
        if (r == -1) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(l+1);
        res.add(r+1);
        return res;        
    }

    public ArrayList<Integer> flip01(String A) {
        int n = A.length();
        int[] temp = new int[n];

        for (int i=0; i<n; i++) {
            char c = A.charAt(i);
            if (c == '0') temp[i] = 1;
            else temp[i] = -1;
        }

        int r = -1, l = -1, start = 0;
        int sum = 0;
        int max = 0;
        for (int i=0; i<n; i++) {
            sum += temp[i];
            if (sum > max) {
                r = i;
                l = start;
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
                start = i+1;
            }
        }
        if (r == -1) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(l+1);
        res.add(r+1);
        return res;
    }
}