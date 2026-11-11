class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        List<Integer> take = new ArrayList<>();

        for(int i=0; i<grid.length; i++){
            Arrays.sort(grid[i]);

            for(int j=0; j<limits[i]; j++){
                take.add(grid[i][grid[i].length-1-j]);
            }
        }

        Collections.sort(take);

        long ans = 0;

        for(int i=0; i<k; i++){
            ans += (long)take.get(take.size()-1-i);
        }

        return ans;
    }
}