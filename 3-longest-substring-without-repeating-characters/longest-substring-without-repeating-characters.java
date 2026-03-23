class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];   
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            freq[c]++;

            while (freq[c] > 1) {
                freq[s.charAt(left)]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}