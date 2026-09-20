class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[2 * nums.length];

        for(int i=0; i<nums.length; i++){
            ans[i] = nums[i];
            ans[ans.length-1-i] = nums[i];
        }
        return ans;
    }
}