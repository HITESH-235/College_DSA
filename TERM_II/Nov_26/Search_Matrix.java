// LEETCODE link: https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/1840377891/

package College_DSA.TERM_II.Nov_26;
public class Search_Matrix {

    public boolean searchMatrix_BF(int[][] matrix, int target) {
        for (int curr[]: matrix) {
            for (int e: curr) {
                if (e == target) return true;
            }
        } 
        return false;
    }


    public boolean searchArray_BS(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int r = m-1;

        for (int i=0; i<n; i++) {
            int upper = upperBound(matrix[i], 0, r, target);
            if (upper <= 0) return false;
            if (matrix[i][upper-1] == target) return true;
            r = upper-1;
        }
        return false;
    }
    public int upperBound(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] > target) r = mid-1;
            else l = mid+1;
        }
        return l;
    }

    
    public boolean searchArray_LS(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        
        int r = 0, c = m-1;
        while (r<=n && c>=0) {
            if (matrix[r][c] == target) return true;
            
            if (matrix[r][c] > target) c--;
            else r++;
        } 
        return false;
    }
}