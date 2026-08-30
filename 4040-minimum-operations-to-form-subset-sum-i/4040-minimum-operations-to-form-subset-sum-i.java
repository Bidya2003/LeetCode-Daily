/*
class Solution {
    public int checkOperations(int[] nums, int[][] dp, int sum, int idx) {
        if(sum==0) return 0;
        if(idx >= nums.length) return -1;
        if(sum<0) return -1;

        if(dp[idx][sum]!= -1){
            return dp[idx][sum];
        }

        int norm = -1;
        if(nums[idx] <= sum){
            norm = checkOperations(nums, dp, sum - nums[idx], idx + 1);
        }
        
        int skip = checkOperations(nums,dp,sum,idx+1);
        
        int modCount = Integer.MAX_VALUE;
        int mulCount = Integer.MAX_VALUE;
        int count = 0; 
        int n = nums[idx];
        while(n>1){
            n = n/2;
            count++;
            int curr = checkOperations(nums,dp,sum-n,idx+1);
            if(curr!=-1)
                modCount = Math.min(modCount,count+curr);
        }
        int m = nums[idx];
        count = 0;
        while(m*2 <= sum){
            m = m*2;
            count++;
            int curr = checkOperations(nums,dp,sum-m,idx+1);
            if(curr!=-1)
                mulCount = Math.min(mulCount,count+curr);
        }
        
        int ans = (mulCount<modCount) ? mulCount : modCount;

        if(norm != -1){
            ans = Math.min(norm,ans);
        }

        if(skip != -1){
            ans = Math.min(skip,ans);
        }
        return dp[idx][sum] = (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
    public int minOperations(int[] nums, int sum) {
        int same = nums[0]; boolean similar = false;
        for(int i : nums){
            if(i!=same){
                similar = true;
                break;
            }
        }

        int[][] dp = new int[nums.length][sum+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        if(similar==false && same!=1){
            int rest = sum/same;
            if(sum>same && sum%2 != 0) return -1;
            int sum1 = sum % same;
            return checkOperations(nums,dp,sum1,rest);
        }
        
        if(similar==false && same==1){
            int count = 0; int mul; int oneCount = 0;
            while(sum>0){
                mul = 1;
                while(mul*2<=sum){
                    mul = mul*2;
                    count++;
                }
                sum = sum-mul;
                oneCount++;
            }
            if(oneCount<=nums.length && sum==0)
                return count;
            else
                return -1;
        }
        
        return checkOperations(nums,dp,sum,0);
    }
}

*/

class Solution {
    public int minOperations(int[] nums, int sum) {
        int n = nums.length;

        int[][] dp = new int[n + 1][sum + 1];
        for(int[] row : dp)
            Arrays.fill(row, (int) 1e8);

        dp[0][0] = 0;

        for(int i = 0; i < n; i++) {

            for(int s = 0; s <= sum; s++) {
                if(dp[i][s] == (int) 1e8) continue;

                // don't take
                dp[i + 1][s] = Math.min(dp[i + 1][s], dp[i][s]);

                // take: try every value nums[i] can turn into
                long val = nums[i];
                int mul = 0;

                while(val <= 1L * sum * 2 || mul == 0) {
                    long cur = val;
                    int div = 0;

                    while(cur > 0) {
                        if(cur <= sum && s + cur <= sum) {
                            dp[i + 1][s + (int) cur] = Math.min(dp[i + 1][s + (int) cur], dp[i][s] + mul + div);
                        }

                        cur /= 2;
                        div++;
                    }

                    val *= 2;
                    mul++;
                }

                int d = nums[i] / 2;

                if(s + d <= sum) {
                    dp[i + 1][s + d] = Math.min(dp[i + 1][s + d], dp[i][s] + 1);
                }
            }
        }

        int res = dp[n][sum];

        return res >= 1e8 ? -1 : res;
    }
}
