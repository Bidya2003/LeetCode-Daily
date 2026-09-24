class Solution {
    public int minOperations(int[] nums) {
        int same = nums[0];

        for(int i : nums){
            if(i != same)
                return 1;
        }

        return 0;
    }
}