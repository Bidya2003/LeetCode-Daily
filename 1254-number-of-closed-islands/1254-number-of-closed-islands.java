class Solution {
    public void findClosedIsland(int[][] grid, int row, int col, boolean[][]visited) {
        if(row<0 || col<0 || row>=grid.length || col>= grid[0].length || grid[row][col]!=0 || visited[row][col]==true) return;

        visited[row][col]=true;

        findClosedIsland(grid,row-1,col,visited);
        findClosedIsland(grid,row+1,col,visited);
        findClosedIsland(grid,row,col-1,visited);
        findClosedIsland(grid,row,col+1,visited);
    }
    public void checkBoarderedIslands(int[][] grid, int row, int col) {
        if(row<0 || col<0 || row>=grid.length || col>= grid[0].length || grid[row][col]!=0) return;

        grid[row][col] = -1;

        checkBoarderedIslands(grid,row-1,col);
        checkBoarderedIslands(grid,row+1,col);
        checkBoarderedIslands(grid,row,col-1);
        checkBoarderedIslands(grid,row,col+1);
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int row=0;row<n;row++){
            if(grid[row][0]==0){
                checkBoarderedIslands(grid,row,0);
            }
            if(grid[row][m-1]==0){
                checkBoarderedIslands(grid,row,m-1);
            }
        }
        for(int col=0;col<m;col++){
            if(grid[0][col]==0){
                checkBoarderedIslands(grid,0,col);
            }
            if(grid[n-1][col]==0){
                checkBoarderedIslands(grid,n-1,col);
            }
        }

        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]==0 && visited[row][col]==false){
                    count++;
                    findClosedIsland(grid,row,col,visited);
                }
            }
        }

        return count;
    }
}