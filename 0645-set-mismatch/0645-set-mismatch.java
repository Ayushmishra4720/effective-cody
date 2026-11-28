class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        // Step 1: Mark visited indices as negative to find the duplicate
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                duplicate = Math.abs(num);
            } else {
                nums[idx] *= -1;
            }
        }

        // Step 2: Find the index that remained positive
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
