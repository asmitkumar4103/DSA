class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;     
        int p = 0, q = 0;    
        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(p) != word2[j].charAt(q))
                return false;

            p++;
            q++;

            if (p == word1[i].length()) {  
                p = 0;
                i++;
            }
            if (q == word2[j].length()) {
                q = 0;
                j++;
            }
        }

        return i == word1.length && j == word2.length;
    }
}