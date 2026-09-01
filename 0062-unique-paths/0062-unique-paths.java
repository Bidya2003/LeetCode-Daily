class Solution {
    public int totalPaths(int row, int col, int m , int n, int[][] dp) {
        if(row>=m || col>=n)
            return 0;

        if(row==m-1 && col==n-1)
            return 1;

        if(dp[row][col] != -1)
            return dp[row][col];

        return dp[row][col] = totalPaths(row+1,col,m,n,dp) + totalPaths(row,col+1,m,n,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return totalPaths(0,0,m,n,dp);
    }
}