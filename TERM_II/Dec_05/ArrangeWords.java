package College_DSA.TERM_II.Dec_05;

public class ArrangeWords {
    public static int arrangeAlpha(String s) {
        int n = s.length();
        int space = 0;
        
        boolean temp2[] = new boolean[26];

        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                temp2[c-'a'] = true;
                StringBuilder x = new StringBuilder();
                int j = i;
                while (i<n && s.charAt(i) != ' ') {
                    i++;
                }
                
                i--;
            }
            else space++;
        }
        String[] final = new String[space+1];
        for (int i=0; i<26; i++) {
            if (temp[i]) {
                for (char c: )
            }
        }
    }
}
