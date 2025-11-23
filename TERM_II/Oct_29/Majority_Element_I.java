// Majority Element-I
// LEETCODE link: https://leetcode.com/problems/majority-element/description/
// return the number in given array that appears more than n/2 times

package College_DSA.TERM_II.Oct_29;
import java.util.*;
public class Majority_Element_I {

    public int majorityElement_BF(int[] nums) {
        int n = nums.length;
        for (int curr: nums) {
            int count = 0;
            for (int e: nums) {
                if (curr == e) {
                    count++;
                }
            }
            if (count>n/2) return curr;
        }
        return -1;
    }
    
    public int majorityElement_Hash(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int e: nums) {
            map.put(e,map.getOrDefault(e, 0)+1);
        }
        for (int key:map.keySet()) {
            if (map.get(key) > n/2) return key;
        }
        return -1;
    } 

    public int majorityElement(int[] nums) {
        int c = 1;
        int curr = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (curr == nums[i]) c++;
            else c--;
            if (c<=0) {
                curr = nums[i];
                c = 1;
            }
        }
        return curr;
    }    
}
