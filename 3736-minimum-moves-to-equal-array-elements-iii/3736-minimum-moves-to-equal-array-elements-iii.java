class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }

        int steps = 0;

        for(int i : nums){
            steps += (max-i);
        }

        return steps;
    }
}