class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length/2];
        // int total = 0;
        // for(int i : nums){
        //     total += i;
        // }
        // int mid = total / nums.length;
        int ans = 0;
        for(int i : nums){
            ans += Math.abs(mid - i);
        }
        return ans;
    }
}