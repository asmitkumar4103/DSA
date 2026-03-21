class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0;
        int map[] = new int[128];

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, map[c]);
            maxLen = Math.max(maxLen, right - left + 1);
            map[c] = right + 1;
        }
        return maxLen;
    }
}