class Solution {
    public void kthCyclicShift(int[] grid, int start, int end){
        while(start < end){
            int temp = grid[start];
            grid[start] = grid[end];
            grid[end] = temp;
            start++;
            end--;
        }
    }
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for(int row=0; row<rowShift.length; row++){
            kthCyclicShift(grid[row], 0, grid.length-1);
            kthCyclicShift(grid[row], 0, grid.length-1-rowShift[row]);
            kthCyclicShift(grid[row], grid.length-rowShift[row], grid.length-1);
        }

        for(int col=0; col<colShift.length; col++){
            int[] colArr = new int[grid[col].length];
            for(int i=0; i<grid[col].length; i++){
                colArr[i] = grid[i][col];
            }
            kthCyclicShift(colArr, 0, grid[col].length-1);
            kthCyclicShift(colArr, 0, grid[col].length-1-colShift[col]);
            kthCyclicShift(colArr, grid[col].length-colShift[col], grid[col].length-1);

            for(int i=0; i<grid[col].length; i++){
                grid[i][col] = colArr[i];
            }
        }

        return grid;
    }
}