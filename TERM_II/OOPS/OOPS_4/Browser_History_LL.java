// You have a browser of one tab where you start on the homepage 
// and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

// Implement the BrowserHistory class:

// 1.BrowserHistory(string homepage): 
// Initializes the object with the homepage of the browser.
// 2.void visit(string url):
// Visits url from the current page. It clears up all the forward history.
// 3.string back(int steps):
// Move steps back in history. Return the current url after moving back in history at most steps.
// 4.string forward(int steps):
// Move steps forward in history. Return the current url after forwarding in history at most steps.

package College_DSA.TERM_II.OOPS.OOPS_4;
public class Browser_History_LL {
    
    private Node head;
    private Node curr;

    Browser_History_LL(String homepage) {
        head = new Node(homepage);
        curr = head;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    public String back(int steps) {
        while (curr.prev != null && steps > 0) {
            curr = curr.prev;
            steps--;
        }
        return curr.data;
    }

    public String forward(int steps) {
        while (curr.next != null && steps > 0) {
            curr = curr.next;
            steps--;
        }
        return curr.data;
    }
}

class Node {
    String data;
    Node next;
    Node prev;

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.next = null;
    }
}


// Input:
// ["BrowserHistory","visit",       "visit",         "visit",       "back","back","forward","visit",       "forward",  "back",  "back"]
// [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],   [1],   [1],    ["linkedin.com"],[2],        [2],     [7]]
// Output:
// [null,            null,          null,            null,          "face","google","face",   null,        "linkedin","google","leetc"]