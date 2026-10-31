// class Solution {
//     int ans;

//     public void checkAllUniquePaths(int[][] grid, int row, int col, char prev) {
//         if(row >= grid.length || col >= grid[0].length){
//             return;
//         }
//         if(row == grid.length-1 && col == grid[0].length-1){
//             ans++;
//             return;
//         }

//         if(prev == 'R' && grid[row][col] == 1){
//             checkAllUniquePaths(grid, row, col+1, 'D');
//         }
//         else if(prev == 'D' && grid[row][col] == 1){
//             checkAllUniquePaths(grid, row+1, col, 'R');
//         }
//         else{
//             checkAllUniquePaths(grid, row, col+1, 'D');
//             checkAllUniquePaths(grid, row+1, col, 'R');
//         }
//     }
//     public int uniquePaths(int[][] grid) {
//         ans = 0;
//         checkAllUniquePaths(grid, 0, 0, 'S');
//         return ans;
//     }
// }

class Solution {

    int[][][] dp;

    public int checkAllUniquePaths(int[][] grid, int row, int col, char prev) {

        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        int p;

        if (prev == 'S') {
            p = 0;
        }
        else if (prev == 'R') {
            p = 1;
        }
        else {
            p = 2;
        }

        // age calculate hoye geche
        if (dp[row][col][p] != -1) {
            return dp[row][col][p];
        }

        int ans = 0;

        if (prev == 'R' && grid[row][col] == 1) {

            ans += checkAllUniquePaths(
                grid, row, col + 1, 'D'
            );
        }

        else if (prev == 'D' && grid[row][col] == 1) {

            ans += checkAllUniquePaths(
                grid, row + 1, col, 'R'
            );
        }

        else {

            ans += checkAllUniquePaths(
                grid, row, col + 1, 'D'
            );

            ans += checkAllUniquePaths(
                grid, row + 1, col, 'R'
            );
        }

        return dp[row][col][p] = ans;
    }

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return checkAllUniquePaths(grid, 0, 0, 'S');
    }
}