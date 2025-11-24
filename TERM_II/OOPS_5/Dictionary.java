// Design a data structure that supports adding & searching for words with optional wildcard characters.

// Implement the following functions:
// Dictionary() — Initializes the object.
// void addWord(word) — Adds a word (containing lowercase English letters) to the structure.
// bool search(word) — Returns true if there is any word in the structure that matches word; word may contain dots '.', where each dot can represent any single letter.

package College_DSA.TERM_II.OOPS_5;
import java.util.*;
public class Dictionary {
    
    List<String> set; // collection of all words
    Dictionary() {
        this.set = new ArrayList<>();
    }
    void addWord(String word) {
        set.add(word);
    }
    boolean search(String word) {
        for (String s: set) {
            if (s.length() != word.length()) continue;
            boolean flag = true;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) != word.charAt(i) && word.charAt(i) != '.') {
                    flag = false;
                    break; // break loop for traversing curr word in set
                }
            }
            if (flag) return true; // if flag remained true for a word
        }
        return false; // if flag could never return true
    }
}