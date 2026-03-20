class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        
        int start = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] odd = expand(s, i, i);
            int[] even = expand(s, i, i + 1);
            
            if (odd[1] - odd[0] + 1 > maxLen) {
                start = odd[0];
                maxLen = odd[1] - odd[0] + 1;
            }
            if (even[1] - even[0] + 1 > maxLen) {
                start = even[0];
                maxLen = even[1] - even[0] + 1;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private int[] expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[]{l + 1, r - 1};
    }
}