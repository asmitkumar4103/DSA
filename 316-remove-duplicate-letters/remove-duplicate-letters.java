class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] inStack = new boolean[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            if (inStack[idx]) continue;

            while (stack.length() > 0 &&
                   c < stack.charAt(stack.length() - 1) &&
                   freq[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(c);
            inStack[idx] = true;
        }

        return stack.toString();
    }
}