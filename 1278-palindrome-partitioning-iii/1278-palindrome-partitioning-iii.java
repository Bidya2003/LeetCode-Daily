class Solution {
    int[][] cost;
    int[][] dp;

    public int changeForPalindrome(String curr, int left, int right){
        //Palindrome check
        int count = 0;

        while(left<=right){
            if(curr.charAt(left) != curr.charAt(right)){
                count++;
            }
            left++;
            right--;
        }

        return count;
    }
    public int minimumChanges(int k, int idx, int n) {
        if(k == 1){
            return cost[idx][n-1];
        }

        if(dp[idx][k] != -1)
            return dp[idx][k];
        
        int ans = Integer.MAX_VALUE;

        for(int i=idx; i < n-(k-1); i++){

            //Palindrome check
            int count = cost[idx][i] + minimumChanges(k-1, i+1, n);

            ans = Math.min(ans, count);
        }

        return dp[idx][k] = ans;
    }
    public int palindromePartition(String s, int k) {
        int n = s.length();

        cost = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                cost[i][j] = changeForPalindrome(s, i, j);
            }
        }

        dp = new int[n][k+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return minimumChanges(k, 0, n);
    }
}

