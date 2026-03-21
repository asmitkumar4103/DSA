import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String segment = s.substring(index, index + len);

            if (!isValid(segment)) continue;

            path.add(segment);
            backtrack(s, index + len, path, result);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String seg) {
        if (seg.length() > 1 && seg.charAt(0) == '0') return false;
        int val = Integer.parseInt(seg);
        return val >= 0 && val <= 255;
    }
}