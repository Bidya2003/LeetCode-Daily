class Solution {
    public int findChampion(int[][] grid) {
        int count = 0;
        int team = -1;

        for(int i=0; i<grid.length; i++){
            int total = 0;
            for(int j=0; j<grid[i].length; j++){
                total += grid[i][j];
            }

            if(total > count){
                count = total;
                team = i;
            }
        }

        return team;
    }
}