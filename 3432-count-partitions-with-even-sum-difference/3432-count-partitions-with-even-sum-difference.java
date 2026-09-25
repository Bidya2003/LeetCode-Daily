class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;

        for(int i : nums){
            total += i;
        }

        int left = 0;
        int count = 0;

        for(int i=0; i<nums.length-1; i++){
            left += nums[i];

            total -= nums[i];

            if((left - total) % 2 == 0){
                count++;
            }
        }

        return count;
    }
}