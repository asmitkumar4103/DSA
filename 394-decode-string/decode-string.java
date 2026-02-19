class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String curr = "";
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');   // build full number (e.g., 12[a])
            } 
            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(curr);
                num = 0;
                curr = "";
            } 
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());

                while (repeat-- > 0) {
                    temp.append(curr);
                }

                curr = temp.toString();
            } 
            else {
                curr += ch;  // add normal characters
            }
        }

        return curr;
    }
}
