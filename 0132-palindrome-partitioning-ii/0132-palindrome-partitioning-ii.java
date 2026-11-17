class Solution {
    boolean[][] isPalindrome;
    int[] dp;

    public int minCutCount(int idx, int n){
        if(idx == n)
            return 0;

        if(dp[idx] != -1){
            return dp[idx];
        }

        int ans = n;
        
        for(int i=n-1; i>=idx; i--){
            if(isPalindrome[idx][i] == false)
                continue;

            ans = Math.min(ans, 1 + minCutCount(i+1,n));
        }

        return dp[idx] = ans;
    }

    public int minCut(String s) {
        int n = s.length();

        isPalindrome = new boolean[n][n];

        for(int i=0; i<n; i++){
            isPalindrome[i][i] = true;
        }

        for(int len =2; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j)){
                    if(len == 2 || isPalindrome[i+1][j-1]){
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        dp = new int[n];
        Arrays.fill(dp, -1);

        return minCutCount(0,n) - 1;
    }
}