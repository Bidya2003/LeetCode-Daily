/*

//Time Limit Exceeded (88 / 92 testcases passed)

class Solution {
    boolean[][] palindrome;
    int[][] dp;

    public boolean isPalindrome(String curr, int left, int right){
        while(left <= right){
            if(curr.charAt(left) != curr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean checkPartitioningPalindromeOrNot(int idx, int k, int n){
        if(idx == n)
            return k == 0;

        if(k == 0 || n - idx < k)
            return false;

        if(k == 1){
            return palindrome[idx][n-1];
        }

        if(dp[idx][k] != -1){
            return dp[idx][k] == 1;
        }

        for(int i = idx; i < n-1; i++){
            if(!palindrome[idx][i])
                continue;

            if(checkPartitioningPalindromeOrNot(i+1, k-1, n)){
                dp[idx][k] = 1;
                return true;
            }
        }

        dp[idx][k] = 0;
        return false;
    }

    public boolean checkPartitioning(String s) {
        int n = s.length();

        palindrome = new boolean[n][n];

        for(int i = 0; i < n; i++){
            palindrome[i][i] = true;

            for(int j = i+1; j < n; j++){
                palindrome[i][j] = isPalindrome(s, i, j);
            }
        }

        dp = new int[n][4];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return checkPartitioningPalindromeOrNot(0, 3, n);
    }
}
*/

class Solution {
    boolean[][] palindrome;
    int[][] dp;

    ////Time Limit Exceeded (88 / 92 testcases passed)
    /*
    public boolean isPalindrome(String curr, int left, int right){
        while(left <= right){
            if(curr.charAt(left) != curr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    */

    public boolean checkPartitioningPalindromeOrNot(int idx, int k, int n){
        if(idx == n)
            return k == 0;

        if(k == 0 || n - idx < k)
            return false;

        if(k == 1){
            return palindrome[idx][n-1];
        }

        if(dp[idx][k] != -1){
            return dp[idx][k] == 1;
        }

        for(int i = idx; i < n-1; i++){
            if(!palindrome[idx][i])
                continue;

            if(checkPartitioningPalindromeOrNot(i+1, k-1, n)){
                dp[idx][k] = 1;
                return true;
            }
        }

        dp[idx][k] = 0;
        return false;
    }

    public boolean checkPartitioning(String s) {
        int n = s.length();

        palindrome = new boolean[n][n];

        /*
        for(int i = 0; i < n; i++){
            palindrome[i][i] = true;

            for(int j = i+1; j < n; j++){
                palindrome[i][j] = isPalindrome(s, i, j);
            }
        }
        */

        for(int i=0; i<n; i++){
            palindrome[i][i] = true;
        }

        for(int len=2; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i+len-1;

                if(s.charAt(i) == s.charAt(j)){
                    if(len == 2 || palindrome[i+1][j-1]){
                        palindrome[i][j] = true;
                    }
                }
            }
        }

        dp = new int[n][4];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return checkPartitioningPalindromeOrNot(0, 3, n);
    }
}
