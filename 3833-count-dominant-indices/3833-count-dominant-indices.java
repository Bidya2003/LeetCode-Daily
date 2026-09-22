class Solution {
    public int dominantIndices(int[] nums) {
        int total = 0;
        for(int i : nums){
            total+=i;
        }

        int ans = 0;
        for(int i=0; i<nums.length-1; i++){
            total = total - nums[i];

            if(nums[i] > (total/(nums.length-1-i))){
                ans++;
            }
        }

        return ans;
    }
}