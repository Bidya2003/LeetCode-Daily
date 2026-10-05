class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];

        for(int col=0; col<grid[0].length; col++){
            int max = 0;
            for(int row=0; row<grid.length; row++){
                int len = 0;
                int nums = grid[row][col];

                if(nums <= 0){
                    len++;
                    nums = Math.abs(nums);
                }

                while(nums != 0){
                    len++;
                    nums = nums / 10;
                }

                max = Math.max(max, len);
            }

            ans[col] = max;
        }

        return ans;
    }
}