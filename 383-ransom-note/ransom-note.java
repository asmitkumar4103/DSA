class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // magazine ke characters count karo
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        // ransomNote ke characters check karo
        for (int i = 0; i < ransomNote.length(); i++) {

            int index = ransomNote.charAt(i) - 'a';

            if (freq[index] == 0) {
                return false;
            }

            freq[index]--;
        }

        return true;
    }
}