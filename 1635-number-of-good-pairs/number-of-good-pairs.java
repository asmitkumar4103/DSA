class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int x : nums) {
            count += freq.getOrDefault(x, 0);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        return count;
    }
}