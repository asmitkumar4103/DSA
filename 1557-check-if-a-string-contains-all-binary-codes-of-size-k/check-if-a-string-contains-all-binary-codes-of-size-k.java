class Solution {
    public boolean hasAllCodes(String s, int k) {
        int total = 1 << k;  
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i + k <= s.length(); i++) {
            String sub = s.substring(i, i + k);
            if (set.add(sub)) {
                total--;
                if (total == 0) return true;
            }
        }
        return false;
    }
}