// make a res string from given string performing following operations:
// - remove Upper case letters
// - change vowels into '#'
// - double this string formed finally
// e.g. A = "Abac"; res = "b#cb#c" ('A' removed; a -> '#') 

package College_DSA.TERM_II.Dec_03;
import java.util.*;
public class String_Operation {

    public String stringOperation(String A) {
        Set<Integer> vowels = new HashSet<>();
        vowels.add(97);
        vowels.add(101);
        vowels.add(105);
        vowels.add(111);
        vowels.add(117);

        StringBuilder res = new StringBuilder();
        for (char c: A.toCharArray()) {
            int asc = c;
            if (vowels.contains(asc)) { // check vowel
                res.append('#');
            }
            else if (asc<65 || asc>90) { // check lowercase
                res.append(c);
            }
        }
        return res.toString() + res.toString();
    }
}