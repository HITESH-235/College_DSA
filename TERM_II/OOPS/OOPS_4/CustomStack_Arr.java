// Link: https://www.scaler.com/academy/mentee-dashboard/class/469982/homework/problems/271813?navref=cl_tt_nv

// Design a stack that supports increment operations on its elements.
// Implement the CustomStack class:
// CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
// void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
// int pop() Pops and returns the top of the stack or -1 if the stack is empty.
// void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.

package College_DSA.TERM_II.OOPS.OOPS_4;
public class CustomStack_Arr {

    private Integer[] st;
    private int top;
    private int maxSize;

    CustomStack_Arr(int maxSize) {
        this.maxSize = maxSize;
        this.st = new Integer[maxSize];
        this.top = -1;
    }

    void push(int x) {
        if (top == maxSize-1) return;
        top++;
        st[top] = x;
    }

    int pop() {
        if (top == -1) return -1;
        int temp = st[top];
        st[top] = null;
        top--;
        return temp; 
    }

    // increase bottom k elements by val
    void inc(int k, int val) {
        if (top+1 <= k) {
            for (int i=0; i<=top; i++) {
                st[i] += val;
            }
            return;
        }
        for (int i=0; i<k; i++) {
            st[i] += val;
        }
    }
}