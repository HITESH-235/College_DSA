// return 1 if a substring is repeated A times to form B when rearranged
// e.g. A = 2, acbcba can be represented as abcabc (abc x2) hence return 1
// A = 3, abcabc return -1 

package College_DSA.TERM_II.Dec_05;
import java.util.*;
public class Repeated_Substr {

    public int repeatedSubstr(int A, String B) {
        if (A % B.length() != 0) return -1;

        Map<Integer,Integer> map = new HashMap<>();
        for (char c: B.toCharArray()) {
            map.put(c-'a', map.getOrDefault(c-'a',0)+1);
        }
                
        for (char c: B.toCharArray()) {
            if (A % map.get(c-'a') != 0) return -1;
        }
        return 1;
    }
}