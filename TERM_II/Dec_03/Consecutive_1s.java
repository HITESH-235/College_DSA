package College_DSA.TERM_II.Dec_03;
public class Consecutive_1s {

    public int consecutive1s_BF(String A) {
        int total = 0;
        for (char c: A.toCharArray()) {
            if (c=='1') total++;
        }
        int res = 0;
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) == '0') {
                int l = i-1;
                while (l>=0 && A.charAt(l) == '1') l--;

                int r = i+1;
                while (r<A.length() && A.charAt(r) == '1') r++;
                
                int possible = (r-l-1);
                if (possible > total) possible = total;

                res = Math.max(possible, res);
            }
        }
        if (res == 0) // no zeroes in String
        return total;
        return res;
    }

    public int consecutive1s_Prefix(String A) {
        int n = A.length();
        int suffix1s[] = new int[n];

        int temp = 0;
        int total = 0;
        for (int i=n-1; i>=0; i--) {
            char c = A.charAt(i);
            if (c == '0') {
                temp = 0;
            }
            else {
                total++;
                temp++;
            }
            suffix1s[i] = temp;
        }
        if (total == A.length()) return total;

        int prefix1s = 0;
        int res = 0;
        for (int i=0; i<n; i++) {
            if (A.charAt(i) == '0') {

                int possible = prefix1s + (i==n-1 ? 0:suffix1s[i+1]) + 1;
                if (possible > total) return total;

                res = Math.max(res, possible);
                prefix1s = 0;
            }
            else {
                prefix1s++;
                res = Math.max(res,prefix1s);
            }
        }
        return res;
    }
}