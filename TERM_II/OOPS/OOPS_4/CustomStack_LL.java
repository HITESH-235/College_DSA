// Link: https://www.scaler.com/academy/mentee-dashboard/class/469982/homework/problems/271813?navref=cl_tt_nv

// Design a stack that supports increment operations on its elements.
// Implement the CustomStack class:
// CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
// void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
// int pop() Pops and returns the top of the stack or -1 if the stack is empty.
// void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.

package College_DSA.TERM_II.OOPS.OOPS_4;
public class CustomStack_LL {
    
    private St_Node top;
    private int maxSize;
    private int size;

    public CustomStack_LL(int maxSize) {
        this.maxSize = maxSize;
        this.top = null;
        size = 0;
    }
    
    public void push(int x) {
        if (size == maxSize) return;
        St_Node newNode = new St_Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    public int pop() {
        if (size == 0) return -1;
        int temp = top.data;

        top = top.next;
        size--;
        return temp;
    }
    
    public void inc(int k, int val) {
        int target = size-k;
        St_Node iter = top;
        if (target < 0) target = 0;

        for (int i=0; i<target; i++) {
            iter = iter.next;
        }

        while (iter != null) {
            iter.data += val;
            iter = iter.next;
        }
    }
}

class St_Node {
    St_Node next;
    int data;
    public St_Node(int data) {
        this.data = data;
        this.next = null;
    }
}