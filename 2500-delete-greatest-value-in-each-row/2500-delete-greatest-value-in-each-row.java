class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int total = 0;
        int n = 0;

        while(n < grid[0].length){
            int maximum = Integer.MIN_VALUE;

            for(int row=0; row<grid.length; row++){
                int max = -1;
                int idx = -1;
                for(int col=0; col<grid[row].length; col++){
                    if(max < grid[row][col]){
                        max = grid[row][col];
                        idx = col;
                    }
                }
                grid[row][idx] = -1;
                maximum = Math.max(maximum, max);
            }
            total += maximum;
            n++;
        }

        return total;
    }
}