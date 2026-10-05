class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for(int i : nums){
            total += i;
        }

        int leftSum = 0;

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            total -= num;
            nums[i] = Math.abs(total - leftSum);
            leftSum += num;
        }

        return nums;
    }
}