class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 1000000007;

        int[] dp = new int[n+1];
        dp[0]= 1;

        int[] last = new int[26];
        Arrays.fill(last,-1);

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            dp[i+1] = (2 * dp[i]) % MOD;


            if(last[ch-'a'] != -1){
                dp[i+1] = dp[i+1] - dp[last[ch-'a']-1];

                if(dp[i+1]<0)
                    dp[i+1] = dp[i+1] + MOD;
            }
            
            last[ch-'a'] = i+1;
        }

        return (dp[n]-1<0) ? (dp[n]+MOD-1) : dp[n]-1;
    }
}