class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        int nonZero = 0;

        while(zero<nums.length && nonZero<nums.length){
            if(nums[zero] != 0){
                zero++;
                nonZero++;
            }
            else if(nums[nonZero] == 0){
                nonZero++;
            }
            else if(nums[zero]==0 && nums[nonZero] != 0){
                nums[zero] = nums[nonZero];
                nums[nonZero] = 0;
                zero++;
                nonZero++;
            }
        }
    }
}