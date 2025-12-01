package College_DSA.TERM_II.Dec_01;
import java.util.*;
public class First_Missing_Positive {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,-5,5,6,6,7,8};
        First_Missing_Positive obj = new First_Missing_Positive();

        System.out.println(obj.firstMissingPositive(arr));
        System.out.println(Arrays.toString(arr));
    }

    public int firstMissingPositive_BF(int arr[]) {
        int n = arr.length;
        boolean found;
        for (int i=1; i<=n; i++) {
            found = false;
            for (int j=0; j<n; j++) {
                if (i == arr[j]) found = true;
            }
            if (!found) return i;
        }
        return n+1;
    }
    
    public int firstMissingPositive(int arr[]) {
        cyclicSort(arr, 1);

        int res = 1;
        for (int e: arr) {
            if (res != e) {
                return res;
            }
            res++;
        }
        return res;
    }

    public void cyclicSort(int arr[], int start) {
        int n = arr.length, i = 0;
        while (i<n) {
            int correct = arr[i]-start;
            if (correct>=0 && correct<n && arr[correct]!=arr[i]) {
                swap(arr,i,correct);
            }
            else i++;
        }
    }

    public void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
