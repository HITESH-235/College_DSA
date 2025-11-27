// There is an ATM machine that stores banknotes of 5 denominations: 20, 50, 100, 200, and 500 dollars
// Initially the ATM is empty. The user can use the machine to deposit or withdraw any amount of money

// When withdrawing, the machine prioritizes using banknotes of larger values:
// e.g., if you want to withdraw \$300 and there are 2x \$50, 1x \$100, 1x \$200 , then machine uses the 1x $100 and 1x $200
// However, if you try to withdraw $600 and there are 3x $200 and 1x $500, then the withdraw request will be rejected 

// Implement the ATM class:
// ATM() Initializes the ATM object.
// void deposit(int[] banknotesCount) Deposits new banknotes in the order $20, $50, $100, $200, and $500.
// int[] withdraw(int amount) Returns an array of length 5 of the number of banknotes that will be handed to the user;
// in the order $20, $50, $100, $200, and $500, update the number of banknotes in the ATM after withdrawing. 
// Returns [-1] if it is not possible (do not withdraw any banknotes in this case).

package College_DSA.TERM_II.OOPS.OOPS_5;
import java.util.*;
public class ATM {
    private Map<Integer,Integer> map;
    private int[] notes;
    public ATM() {
        this.notes = new int[]{20,50,100,200,500};
        this.map = new HashMap<>();
        for (int note: notes) {
            map.put(note,0);
        }
    }

    public void deposit(int[] bankNotesCount) {
        for (int i=0; i<5; i++) {
            map.put(notes[i], map.get(notes[i])+bankNotesCount[i]);
        }
    }

    public int[] withdraw(int amt) {
        int res[] = new int[5]; // for the count of notes used
        Map<Integer,Integer> tempMap = new HashMap<>(map);
        for (int i=4; i>=0; i--) {
            int note = notes[i];
            int curr = tempMap.get(note);

            if (note <= amt && curr != 0) {
                int req = amt/note; // max count of that note req
                if (req > curr) { // case where the max count is not available
                    amt -= curr * note;
                    tempMap.put(note,0);
                    res[i] = curr;
                }
                else { // case where more than req count
                    amt -= req * note; // hence just take the req count
                    tempMap.put(note,curr-req); // left count of that note
                    res[i] = req;
                }
            }
        }
        if (amt > 0) { // case where notes were not enough
            return new int[]{-1};
        }
        map = tempMap; // else update map of notes
        return res; // count of each note used
    }
}
