class Solution {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= target) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[j] <= target - nums[i]) {
            if (nums[i] = nums[j] == target) {
              return new int[] { i, j };
            }
          }
        }
      }
    }
  }
}