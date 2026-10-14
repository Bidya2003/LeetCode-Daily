class Solution {
    int total;

    public int checkAllSubsetXORSum(int[] nums, int idx, int xor) {
        if(idx == nums.length)
            return xor;
        
        int skip = checkAllSubsetXORSum(nums, idx+1, xor);
        int take = checkAllSubsetXORSum(nums, idx+1, xor^nums[idx]);

        return take + skip;
    }
    public int subsetXORSum(int[] nums) {
        // for(int n : nums){
        //     total += n;
        // }
        
        return checkAllSubsetXORSum(nums, 0, 0);
    }
}