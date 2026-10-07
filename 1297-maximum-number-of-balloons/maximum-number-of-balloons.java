
class Solution {
    public int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        // text ke characters count karo
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        // "balloon" ke liye required characters
        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);

        int res = Integer.MAX_VALUE;

        // har required character check karo
        for (char ch : need.keySet()) {

            int fneed = need.get(ch);
            int fhave = have.getOrDefault(ch, 0);

            int times = fhave / fneed;

            res = Math.min(res, times);
        }

        return res;
    }
}