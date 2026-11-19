class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        int firstRemove = nums[nums.length-1] - nums[2];
        int lastRemove = nums[nums.length-3] - nums[0];
        int bothSideRemove = nums[nums.length-2] - nums[1];

        return Math.min(bothSideRemove, Math.min(firstRemove, lastRemove));
    }
}