// class Solution {
//     int[][] dp;

//     public int checkBothOperations(int[] nums, int left, int right, int x) {
//         if(x==0)
//             return 0;
//         if(x<0 || left>right)
//             return -1;

//         if(dp[left][right] != -2)
//             return dp[left][right];
        
//         int leftMost = checkBothOperations(nums,left+1,right,x-nums[left]);
//         int rightMost = checkBothOperations(nums,left,right-1,x-nums[right]);

//         if(leftMost==-1 && rightMost!=-1)
//             return dp[left][right] = rightMost+1;
//         else if(leftMost!=-1 && rightMost==-1)
//             return dp[left][right] = leftMost+1;
//         else if(leftMost==-1 && rightMost==-1)
//             return dp[left][right] = -1;
        
//         return dp[left][right] = 1 + Math.min(leftMost,rightMost);

//     }
//     public int minOperations(int[] nums, int x) {
//         dp = new int[nums.length][nums.length];
//         for(int [] arr : dp){
//             Arrays.fill(arr,-2);
//         }
//         return checkBothOperations(nums,0,nums.length-1,x);
//     }
// }

class Solution {
    public int minOperations(int[] nums, int x) {

        int total = 0;
        for(int num : nums)
            total += num;

        int target = total - x;

        if(target < 0)
            return -1;

        if(target == 0)
            return nums.length;

        int left = 0;
        int sum = 0;
        int maxLen = -1;

        for(int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while(left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }

            if(sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}