class Solution {
    boolean[][] visited;

    public int countConnectedServers(int[][] grid, int row, int col, char curr) {

        int count = 1;

        if(curr == 'C' || curr == 'S') {
            for(int c = 0; c < grid[0].length; c++) {

                if(grid[row][c] == 1 && !visited[row][c]) {
                    visited[row][c] = true;
                    count += countConnectedServers(grid, row, c, 'R');
                }
            }
        }

        if(curr == 'R' || curr == 'S') {
            for(int r = 0; r < grid.length; r++) {

                if(grid[r][col] == 1 && !visited[r][col]) {
                    visited[r][col] = true;
                    count += countConnectedServers(grid, r, col, 'C');
                }
            }
        }

        return count;
    }

    public int countServers(int[][] grid) {

        int ans = 0;

        visited = new boolean[grid.length][grid[0].length];

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {

                if(visited[row][col] || grid[row][col] == 0) {
                    continue;
                }

                visited[row][col] = true;

                int count = countConnectedServers(grid, row, col, 'S');

                if(count > 1) {
                    ans += count;
                }
            }
        }

        return ans;
    }
}