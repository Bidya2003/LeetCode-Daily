// class Solution {
//     int[][] cost;
//     int[][] dp;

//     public int changeForPalindrome(String s, int start, int end){
//         //Palindrome check
//         int len = end-start+1;
//         int ans = Integer.MAX_VALUE;

//         for(int d=1; d<len; d++){
//             if(len % d != 0)
//                 continue;

//             int count = 0;

//             for(int begin=0; begin<d; begin++){
//                 int left = start + begin;
//                 int right = end - d + begin;

//                 while(left<right){
//                     if(s.charAt(left) != s.charAt(right))
//                         count++;
                    
//                     left += d;
//                     right -= d;
//                 }
//             }

//             ans = Math.min(ans,count);
//         }

//         return ans;
//     }
//     public int minimumChanges(int k, int idx, int n) {
//         if(k==0)
//             return (idx == n)? 0 : 1000000;

//         if(dp[idx][k] != -1){
//             return dp[idx][k];
//         }

//         int ans = Integer.MAX_VALUE;

//         for(int i = idx+2; i <= n - 2*(k-1); i++){
//             int count = cost[idx][i-1] + minimumChanges(k-1, i, n);

//             ans = Math.min(ans, count);
//         }

//         return dp[idx][k] = ans;
//     }
//     public int minimumChanges(String s, int k) {       
//         int n = s.length();
        
//         cost = new int[n][n];

//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 cost[i][j] = changeForPalindrome(s,i,j);
//             }
//         }

//         dp = new int[n+1][k+1];
//         for(int i=0; i<=n; i++){
//             Arrays.fill(dp[i], -1);
//         }

//         return minimumChanges(k, 0, n);
//     }
// }


class Solution {
    int[][] cost;
    int[][] dp;

    public int changeForPalindrome(String s, int start, int end) {
        int len = end - start + 1;
        int ans = Integer.MAX_VALUE;

        for(int d = 1; d < len; d++) {
            if(len % d != 0)
                continue;

            int count = 0;

            for(int begin = 0; begin < d; begin++) {
                int left = start + begin;
                int right = end - ((len - 1 - begin) % d);

                while(left < right) {
                    if(s.charAt(left) != s.charAt(right))
                        count++;

                    left += d;
                    right -= d;
                }
            }

            ans = Math.min(ans, count);
        }

        return ans;
    }

    public int minimumChanges(int k, int idx, int n) {
        if(k == 0)
            return (idx == n) ? 0 : 1000000;

        if(dp[idx][k] != -1)
            return dp[idx][k];

        int ans = Integer.MAX_VALUE;

        for(int i = idx + 2; i <= n - 2*(k-1); i++) {
            int count = cost[idx][i-1] +
                        minimumChanges(k-1, i, n);

            ans = Math.min(ans, count);
        }

        return dp[idx][k] = ans;
    }

    public int minimumChanges(String s, int k) {
        int n = s.length();

        cost = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                cost[i][j] = changeForPalindrome(s, i, j);
            }
        }

        dp = new int[n+1][k+1];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minimumChanges(k, 0, n);
    }
}
