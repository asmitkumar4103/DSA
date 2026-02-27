import java.util.*;

class Solution {
    private int[] original;
    private int[] array;
    Random rand = new Random();

    public Solution(int[] nums) {
        original = nums.clone();
        array = nums.clone();
    }

    public int[] reset() {
        array = original.clone();
        return array;
    }

    public int[] shuffle() {
        int[] shuffled = array.clone();
        for (int i = 0; i < shuffled.length; i++) {
            int j = rand.nextInt(i + 1);
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }
        return shuffled;
    }
}