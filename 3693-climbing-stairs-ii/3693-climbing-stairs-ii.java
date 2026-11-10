
class Solution {
    int[] dp;

    public int minimumClimbCost(int n, int[] costs, int curr) {

        if (curr == n - 1) {
            return 0;
        }

        // Already calculated? Return stored answer
        if (dp[curr + 1] != -1) {
            return dp[curr + 1];
        }

        int next1 = Integer.MAX_VALUE;

        if (curr + 1 < n) {
            next1 = costs[curr + 1] + 1
                  + minimumClimbCost(n, costs, curr + 1);
        }

        int next2 = Integer.MAX_VALUE;

        if (curr + 2 < n) {
            next2 = costs[curr + 2] + 4
                  + minimumClimbCost(n, costs, curr + 2);
        }

        int next3 = Integer.MAX_VALUE;

        if (curr + 3 < n) {
            next3 = costs[curr + 3] + 9
                  + minimumClimbCost(n, costs, curr + 3);
        }

        int min = Math.min(next1, Math.min(next2, next3));

        return dp[curr + 1] = min;
    }

    public int climbStairs(int n, int[] costs) {

        dp = new int[n];
        Arrays.fill(dp, -1);

        return minimumClimbCost(n, costs, -1);
    }
}
