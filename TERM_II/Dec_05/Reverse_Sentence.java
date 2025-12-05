package College_DSA.TERM_II.Dec_05;
import java.util.*;
public class Reverse_Sentence {

    public String reverseSentence_1(String A) {
        int n = A.length();
        
        List<String> temp = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (A.charAt(i) != ' ') {
                int start = i;
                while (i<n && A.charAt(i) != ' ') i++;
                temp.add(A.substring(start,i--));
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i=temp.size()-1; i>=0; i--) {
            res.append(temp.get(i));
            if (i!= 0) res.append(" ");
        }
        return res.toString();
    }

    public String reverseSentence_Split(String A) {
        String[] temp = A.split("");
        StringBuilder res = new StringBuilder();

        for (int i=temp.length-1; i>=0; i--) {
            res.append(temp[i]);
            if (i != 0) res.append(" ");
        }
        return res.toString();
    }
}
