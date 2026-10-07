class Solution {
    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        int idx = 0;
        int i = 0;

        while(i<nums.length-1){
            if(nums[i] == 0){
                i++;
            }
            else if(nums[i] == nums[i+1]){
                ans[idx] = 2 * nums[i];
                i += 2;
                idx++;
            }
            else{
                ans[idx] = nums[i];
                i++;
                idx++;
            }
        }

        // last element
        if(i == nums.length - 1 && nums[i] != 0){
            ans[idx] = nums[i];
            idx++;
        }

        for(int j = idx; j<nums.length; j++){
            ans[j] = 0;
        }
        
        return ans;
    }
}