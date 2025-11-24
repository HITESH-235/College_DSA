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

package College_DSA.TERM_II.OOPS_4;
import java.util.*;
public class Browser_History_Arr {

    private ArrayList<String> pages;
    // Pointer to track the current page index in history
    private int curr;

    // Constructor initializes browser with homepage
    public Browser_History_Arr(String homepage) {
        this.pages = new ArrayList<>();
        this.pages.add(homepage);
        this.curr = 0;
    }

    // Visit a new URL:
    // 1.Remove all forward history (everything after current index)
    // 2.Add new URL and move current pointer to it
    public void visit(String url) {
        int i = pages.size() - 1;

        // Remove previously visited forward pages
        while (i != curr) {
            pages.remove(i);
            i--;
        }

        pages.add(url);
        curr++; // Move current index to the new page
    }

    // Move 'steps' backward in browsing history:
    // - Stop if we reach the earliest page
    public String back(int steps) {
        // If backward steps exceed available history, set to first page
        if (curr + 1 <= steps) {
            curr = 0;
            return pages.get(0);
        }

        curr -= steps;
        return pages.get(curr);
    }

    // Move 'steps' forward in browsing history:
    // - Stop if we reach the latest visited page
    public String forward(int steps) {
        int lastIndex = pages.size() - 1;

        // If forward steps go beyond history, go to last page
        if (lastIndex - curr <= steps) {
            curr = lastIndex;
            return pages.get(lastIndex);
        }

        curr += steps;
        return pages.get(curr);
    }
}

// Input:
// ["BrowserHistory","visit",       "visit",         "visit",       "back","back","forward","visit",       "forward",  "back",  "back"]
// [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],   [1],   [1],    ["linkedin.com"],[2],        [2],     [7]]
// Output:
// [null,            null,          null,            null,          "face","google","face",   null,        "linkedin","google","leetc"]