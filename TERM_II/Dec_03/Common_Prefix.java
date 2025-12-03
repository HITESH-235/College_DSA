package College_DSA.TERM_II.Dec_03;
import java.util.*;
public class Common_Prefix {

    public String commonPrefix(List<String> A) {
        int minLen = Integer.MAX_VALUE;

        for (String s: A) {
            minLen = Math.min(minLen, s.length());
        }
        StringBuilder res = new StringBuilder();

        for (int i=0; i<minLen; i++) {
            char cur = A.get(0).charAt(i);

            for (String s: A) {
                if (s.charAt(i) != cur) {
                    return res.toString();
                }
            }
            res.append(cur);
        }
        return res.toString();
    }
}