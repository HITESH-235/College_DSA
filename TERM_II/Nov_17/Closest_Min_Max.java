// Closest Minium-Maximum Indices
// LINK: https://www.scaler.com/academy/mentee-dashboard/class/470378/assignment/problems/986?navref=cl_tt_nv
// Return the smallest range possible for the minimum and maximum value in an array
// e.g. {1,3,4,24,4,2}: (0:1); (3:24); res = 3-0+1 = 4

package College_DSA.TERM_II.Nov_17;
public class Closest_Min_Max {

    public int closestMinMax(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int e: A) {
            max = Math.max(e,max);
            min = Math.min(e,min);
        }
        int min_i = -1;
        int max_i = -1;

        int res = A.length;
        for (int i=0; i<A.length; i++) {
            int e = A[i];
            if (max == e) {
                max_i = i;
            }
            if (min == e) {
                min_i = i;
            }

            if (min_i != -1 && max_i != -1) {
                res = Math.min(Math.abs(min_i-max_i)+1,res);
            }
        }
        return res;
    }
}