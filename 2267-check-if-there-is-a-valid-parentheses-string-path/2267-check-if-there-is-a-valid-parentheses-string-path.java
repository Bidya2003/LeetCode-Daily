class Solution {

    int[][][] dp;

    public boolean checkAllPaths(char[][] grid, int row, int col, int balance) {

        if(row >= grid.length || col >= grid[0].length || balance < 0)
            return false;

        if(grid[row][col] == '(')
            balance++;
        else
            balance--;

        if(balance < 0)
            return false;

        if(row == grid.length-1 && col == grid[0].length-1)
            return balance == 0;

        if(dp[row][col][balance] != -1)
            return dp[row][col][balance] == 1;

        boolean right = checkAllPaths(grid, row, col+1, balance);
        boolean down = checkAllPaths(grid, row+1, col, balance);

        dp[row][col][balance] = (right || down) ? 1 : 0;

        return right || down;
    }

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][m+n+1];

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                Arrays.fill(dp[i][j], -1);

        return checkAllPaths(grid, 0, 0, 0);
    }
}