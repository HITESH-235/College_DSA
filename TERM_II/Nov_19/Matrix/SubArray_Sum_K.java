/* Count SubArrays with Sum K
LEETCODE link: https://leetcode.com/problems/subarray-sum-equals-k/description/

Question:
- given an array, return the total possible subarrays that have a total sum of K

Explanation:

    A. BRUTE FORCE:
- try every subarray starting from i and ending at j = i....n-1,
hence this requiring 2 loops, one for i =0->n-1, another for j=i->n-1, sum elements in 2nd loop
- whenever sum == k; increase count(res)

    B. PREFIX SUM + HASHMAP:
- maintain running prefix sum; prefix = sum[0...i]; any subarray with sum>=k;
- take the diff = (sum-k) whenever sum >= k; and look for diff in hashmap
- hashmap stores the (prefix sums: freq) at every step, including (0:1) initially

- the hashmap ensure that is (sum-k) was previously available as a subarray;
then that diff can be easily removed from behind to make subarray sum == k
- the total number of ways this can be done on a subarray depends on freq of (sum-k) in hashmap
meaning whenever prefix sum was previously (sum-k); then it makes a new subarray with sum = k
till current pointer; not for previous positions of pointer

- after checking the diff and adding its freq in count(freq); make sure tp update hashmap;
by just adding (currPSum, map.getOrDefault(currPSum,0)+1) to the hashmap */

package College_DSA.TERM_II.Nov_19.Matrix;
import java.util.*;
public class SubArray_Sum_K {

    public int subarraySumK_BF(int[] nums, int k) {
        int n = nums.length;
        int res = 0; // no. of subarrays sum with k
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }

    public int subArraySumK_PrefixHash(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefix = 0, res = 0;
        for (int e: nums) {
            prefix += e;
            res += map.getOrDefault(prefix-k, 0);
            map.put(prefix,map.getOrDefault(prefix, 0)+1);
        }
        return res;
    }
}