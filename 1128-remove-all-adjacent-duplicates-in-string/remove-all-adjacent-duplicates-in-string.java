import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {

        int n = s.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        while (!stack.empty()) {
            res.append(stack.peek());
            stack.pop();
        }

        res.reverse();

        return res.toString();
    }
}