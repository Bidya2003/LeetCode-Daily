class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 0;
        int mul = 1;

        while(idx < nums.length){
            if(k*mul == nums[idx]){
                mul++;
                idx++;
            }
            else if(k*mul > nums[idx]){
                idx++;
            }
            else{
                return k*mul;
            }
        }

        return k*mul;
    }
}