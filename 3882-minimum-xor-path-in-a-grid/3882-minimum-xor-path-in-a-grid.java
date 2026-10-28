/*
class Solution {
    int ans;

    public void calculateMinCost(int[][] grid, int row, int col, int xor) {
        if(row>=grid.length || col>=grid[0].length){
            return;
        }
        
        xor = xor ^ grid[row][col];

        if(row == grid.length-1 && col == grid[0].length-1){
            ans = Math.min(ans,xor);
        }

        calculateMinCost(grid,row+1,col,xor);
        calculateMinCost(grid,row,col+1,xor);

    }
    public int minCost(int[][] grid) {
        ans = Integer.MAX_VALUE;

        calculateMinCost(grid,0,0,0);

        return ans;
    }
}
*/

class Solution {

    int ans;
    boolean[][][] visited;

    public void calculateMinCost(int[][] grid, int row, int col, int xor) {

        if (row >= grid.length || col >= grid[0].length) {
            return;
        }

        xor = xor ^ grid[row][col];

        // same cell + same XOR age process korechi
        if (visited[row][col][xor]) {
            return;
        }

        visited[row][col][xor] = true;

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            ans = Math.min(ans, xor);
            return;
        }

        calculateMinCost(grid, row + 1, col, xor);
        calculateMinCost(grid, row, col + 1, xor);
    }

    public int minCost(int[][] grid) {

        ans = Integer.MAX_VALUE;

        visited = new boolean[grid.length][grid[0].length][1024];

        calculateMinCost(grid, 0, 0, 0);

        return ans;
    }
}