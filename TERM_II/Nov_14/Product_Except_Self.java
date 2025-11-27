// Product of Array Except Self
// LEETCODE link: https://leetcode.com/problems/product-of-array-except-self/description/

// Return a res array with each index with product of all other indices' values 
// e.g. {1,2,3,4,5} -> {120,60,40,30,24}
// Constraint is that using Division operator is not allowed

package College_DSA.TERM_II.Nov_14;
public class Product_Except_Self {

    public int[] productExceptSelf_BF(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            int prod = 1;
            for (int j=0; j<n; j++) {
                if (i==j) continue;
                prod *= A[j];
            }
            res[i] = prod;
        }
        return res;
    }

    public int[] productExceptSelf_Opt(int[] A) {
        int n = A.length;
        int[] suffix = new int[n+1]; // suffix product array
        suffix[n] = 1;

        for (int i=n-1; i>=0; i++) {
            suffix[i] = suffix[i+1] * A[i];
        }
        int prefix = 1; // prefix product integer
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = suffix[i+1] * prefix;
            prefix *= A[i];
        }
        return res;
    }
}
