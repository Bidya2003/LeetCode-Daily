class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int longest = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 != 0 || nums[i] > threshold)
                continue;

            int j = 0;

            for(j = i+1; j<nums.length; j++){
                if(nums[j] % 2 == nums[j-1] % 2 || nums[j] > threshold)
                    break;
            }

            longest = Math.max(longest, j-i);
        }

        return longest;
    }
}