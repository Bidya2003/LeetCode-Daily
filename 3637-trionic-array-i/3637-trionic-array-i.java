class Solution {
    public boolean isTrionic(int[] nums) {
        int p = -1;
        int q = -1;

        int i = 0;
        for(i=0; i<nums.length-1; i++){
            if(nums[i] >= nums[i+1]){
                p = i;
                break;
            }
        }

        if(p == -1 || p == 0)
            return false;

        for(int idx=i; idx<nums.length-1; idx++){
            if(nums[idx] <= nums[idx+1]){
                q = idx;
                i = idx;
                break;
            }
        }

        if(q == -1)
            return false;

        for(int idx=i; idx<nums.length-1; idx++){
            if(nums[idx] >= nums[idx+1]){
                return false;
            }
        }

        return true;
    }
}