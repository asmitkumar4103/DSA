class Solution {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 1;
        int uniqueElement = 1;

        while (j < nums.length) {

            if (nums[i] == nums[j]) {
                j++;
                continue;
            }

            i++;
            nums[i] = nums[j];
            uniqueElement++;
            j++;
        }

        return uniqueElement;
    }
}