class Solution {
    public int minimumOperations(int[][] grid) {
        int ope = 0;
        for(int col=0; col<grid[0].length; col++){
            int max = -1;
            for(int row=0; row<grid.length; row++){
                if(grid[row][col] < max){
                    //System.out.println(max - grid[row][col]);
                    ope += (max - grid[row][col]);
                    max++;
                }
                else if(grid[row][col] == max){
                    max++;
                }
                else{
                    max = grid[row][col]+1;
                }
            }
        }

        return ope;
    }
}