// Number of Recent Calls
// LEETCODE link: https://leetcode.com/problems/number-of-recent-calls/description/

// You have a RecentCounter class which counts the number of recent requests within a certain time frame.

// Implement the RecentCounter class:

// RecentCounter() Initializes the counter with zero recent requests.
// int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
// It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

package College_DSA.TERM_II.OOPS.OOPS_5;
import java.util.*;
public class Recent_Calls {
    Queue<Integer> calls;
    public Recent_Calls() {
        calls = new ArrayDeque<>();
    }

    public int ping(int t) {
        calls.offer(t);
        int left = t-3000;
        // int right = t;

        // while (calls.peek()<left || calls.peek()>right) {
        // leetcode guarantees timeStamp calls are increasing
        while (calls.peek()<left) {
            calls.poll(); // first one out if outside range of curr t
        }
        return calls.size();
    }
}

class Recent_Calls_Arr {
    private int[] calls;
    private int start;
    private int end;

    Recent_Calls_Arr() {
        calls = new int[10000]; // problem constraint: calls <= 10^4
        start = 0;
        end = 0;
    }

    int ping(int t) {
        calls[end++] = t;
        // while (calls[start] < t-3000 || calls[start] > t) {
        while (calls[start] < t-3000) {
            start++;
        }
        return end-start;
    }
}