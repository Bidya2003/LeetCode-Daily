/*

//Time Limit Exceeded (554 / 577 testcases passed)

class Solution {
    int[][] changes;
    int[] dp;

    public int allChanges(String s){
        int one = 0;
        int zero = 0;

        for(char c : s.toCharArray()){
            if(c == '1'){
                one++;
            }
            else{
                zero++;
            }
        }

        return Math.min(one, zero);
    }

    public int checkMinChanges(int idx, int n){
        if(idx >= n)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];

        int min = 100000;

        for(int len=2; len<=n; len += 2){
            if(idx+len-1 >= n)
                continue;
            
            min = Math.min(min, changes[idx][idx+len-1] + checkMinChanges(idx+len, n));
        }

        return dp[idx] = min;
    }

    public int minChanges(String s) {
        int n = s.length();
        changes = new int[n][n];

        for(int len = 2; len <= n; len += 2){
            for(int i = 0; i <= n-len; i+=2){
                if(changes[i][i+len-1] != 0)
                    continue;

                changes[i][i+len-1] = allChanges(s.substring(i, i+len));
            }
        }

        dp = new int[n];
        Arrays.fill(dp, -1);

        return checkMinChanges(0, n);
    }
}
*/


class Solution {
    public int minChanges(String s) {
        int n = s.length();

        if(n % 2 != 0)
            return -1;

        long[] dp = new long[n+1];

        int ones = 0;

        long minOne = 0;
        long minZero = 0;

        for(int i = 2; i <= n; i += 2) {

            if(s.charAt(i-2) == '1')
                ones++;

            if(s.charAt(i-1) == '1')
                ones++;

            int zeros = i - ones;

            dp[i] = Math.min(
                ones + minOne,
                zeros + minZero
            );

            minOne = Math.min(
                minOne,
                dp[i] - ones
            );

            minZero = Math.min(
                minZero,
                dp[i] - zeros
            );
        }

        return (int)dp[n];
    }
}
