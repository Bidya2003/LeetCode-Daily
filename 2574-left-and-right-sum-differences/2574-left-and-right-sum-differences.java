class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];

        int total = 0;
        for(int i : nums){
            total += i;
        }

        int leftSum = 0;

        for(int i=0; i<nums.length; i++){
            total -= nums[i];
            ans[i] = Math.abs(total - leftSum);
            leftSum += nums[i];
        }

        return ans;
    }
}