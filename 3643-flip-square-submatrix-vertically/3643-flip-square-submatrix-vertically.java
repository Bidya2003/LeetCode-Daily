class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int rowLimit = x + (k/2);
        int colLimit = y+k;
        int rowTrack = 0;

        for(int row=x; row<rowLimit; row++){

            for(int col = y; col<colLimit; col++){

                int temp = grid[x+k-1-rowTrack][col];
                grid[x+k-1-rowTrack][col] = grid[row][col];
                grid[row][col] = temp;
            }
            rowTrack++;
        }

        return grid;
    }
}