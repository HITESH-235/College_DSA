/*  Plus One
LEETCODE link: https://leetcode.com/problems/plus-one/description/

QUESTION:
- add 1 to number represented by the digit array, e.g. arr = [1,2,4], res = [1,2,5]
- for cases such as A = [0,0,1,0,2,4]; res = [1,0,2,5]

EXPLANATION:
- we need to add 1 to the num represented by the digit array but this fails when
we have cases with a few or all 9's e.g. 89 or 99 because these require carrying
- process digit from last index backward, maintain a carry starting with 1
- if the starting digit becomes 10 after adding carry, carry = 1 again; 
so running a loop (reverse) works as we may have to carry multiple times

- in the loop add the carry in the first iter, i.e., to the last index element; 
hence update the array as long as there are consecutive 9's at the back
- when the first num not 9 is encountered; adding the carry wont get sum as 10;
only then the loop breaks

- loop breaks on 2 conditions; either all indices were found 9; hence carry is still 1
and loop breaks due to i<0; 
- or it breaks on first num from end that is not 9; hence carry = 0

- breaking out of loop if carry is 1; return e.g. 99 -> [1,0,0] (res length = len + 1)
- else just copy the array given into res but remove leading 0s (see code) */

package College_DSA.TERM_II.Nov_26;
public class Plus_One {

    public int[] plusOne(int[] A) {
        int n = A.length;
        int carry = 1;

        // carry right to left
        for (int i=n-1; i>=0; i--) {
            int sum = A[i] + carry; 
            A[i] = sum % 10; // updated digit
            carry = sum / 10; // 0 for sum < 10; 1 for sum == 10
            if (carry == 1) break; // stop if no more carry
        }

        // for cases with only 9's; e.g. 99 -> 100
        if (carry == 1) {
            int res[] = new int[n+1];
            res[0] = 1;
            return res;
        }

        // removing leading zeroes
        int start = 0;
        while (start < n && A[start] == 0) start++;

        int res[] = new int[n-start];
        for (int i=start; i<n; i++) {
            res[i-start] = A[i];
        }
        return res; 
    }
}