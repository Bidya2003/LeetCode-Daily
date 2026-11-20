/*
//Memory Limit Exceeded (661 / 668 testcases passed)

class Solution {
    int[][] dp;

    public int checkAllElements(int[] nums, int idx, int last) {
        if(idx >= nums.length)
            return 0;

        if(dp[idx][last+1] != -1){
            return dp[idx][last+1];
        }

        int skip = checkAllElements(nums, idx+1, last);

        int takeSame = 0;
        int takeIncre = 0;

        if(last == -1 || nums[idx] == last + 1) {
            takeSame = 1 + checkAllElements(nums, idx+1, nums[idx]);
        }

        if(last == -1 || nums[idx] + 1 == last + 1) {
            takeIncre = 1 + checkAllElements(nums, idx+1, nums[idx]+1);
        }

        return dp[idx][last+1] = Math.max(skip, Math.max(takeSame, takeIncre));
    }

    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        dp = new int[nums.length][nums[nums.length-1] + 3];
        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return checkAllElements(nums, 0, -1);
    }
}
*/




class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for(int x : nums) {

            int takeSame = dp.getOrDefault(x - 1, 0) + 1;

            int takeIncre = dp.getOrDefault(x, 0) + 1;

            dp.put(x, Math.max(dp.getOrDefault(x, 0), takeSame));

            dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0), takeIncre));

            ans = Math.max(ans, Math.max(dp.get(x), dp.get(x + 1)));
        }

        return ans;
    }
}
