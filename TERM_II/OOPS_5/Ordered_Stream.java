// LEETCODE link: https://leetcode.com/problems/design-an-ordered-stream/description/

// There is a stream of n (idKey, value) pairs arriving in an arbitrary order;
// where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.

// Design a stream that returns the values in increasing order of their IDs;
// by returning a chunk (list) of values after each insertion. 
// the concatenation of all the chunks should result in a list of the sorted values.

// Implement the Ordered_Stream class:
// 1.Ordered_Stream(int n): Constructs the stream to take n values.
// 2.String[] insert(int idKey, String value): Inserts the pair (idKey, value) into the stream;
//   then returns the largest possible chunk of currently inserted values that appear next in the order.

// Input:
// ["OrderedStream", "insert",     "insert",     "insert",          "insert",     "insert"]
// [[5],             [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"],      [5, "eeeee"], [4, "ddddd"]]
// Output:
// [null,            [],           ["aaaaa"],    ["bbbbb","ccccc"], [],           ["ddddd", "eeeee"]]

package College_DSA.TERM_II.OOPS_5;
import java.util.*;
public class Ordered_Stream {
    String arr[];
    int n;
    int ptr;

    Ordered_Stream(int n) {
        arr = new String[n];
        this.n = n;
        this.ptr = 0;
    }

    List<String> insert(int idKey, String value) {
        arr[idKey-1] = value;
        if (ptr == idKey-1) {
            List<String> res = new ArrayList<>();
            for (int i=idKey-1; i<n; i++) {
                if (arr[i] == null) break;
                ptr++;
                res.add(arr[i]);
            }
            return res;
        }
        else {
            return new ArrayList<>();
        }
    }
}