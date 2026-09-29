class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        //Increasing

        int left = 0;
        int right = 1;

        int increasingLength = right-left;

        while(right < nums.length){
            if(nums[right] > nums[right-1]){
                increasingLength = Math.max(increasingLength, (right-left+1));
                right++;
            }
            else{
                increasingLength = Math.max(increasingLength, (right-left));
                left = right;
                right++;
            }
        }

        //Decreasing
        left = 0;
        right = 1;

        int decreasingLength = right - left;

        while(right < nums.length){
            if(nums[right] < nums[right-1]){
                decreasingLength = Math.max(decreasingLength, (right-left+1));
                right++;
            }
            else{
                decreasingLength = Math.max(decreasingLength, (right-left));
                left = right;
                right++;
            }
        }

        return Math.max(increasingLength, decreasingLength);
    }
}