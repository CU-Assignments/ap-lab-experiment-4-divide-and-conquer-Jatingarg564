class Solution {
    public int maxSubArray(int[] nums) {
        // Base case: If the array has only one element
        if (nums.length == 0) return 0;

        // Initialize maxSum and currentSum with the first element
        int maxSum = nums[0];
        int currentSum = nums[0];

        // Traverse through the array from the second element
        for (int i = 1; i < nums.length; i++) {
            // Either extend the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
