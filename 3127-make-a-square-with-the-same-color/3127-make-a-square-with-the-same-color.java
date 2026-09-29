class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i=0; i<grid.length-1; i++){
            for(int j=0; j<grid[0].length-1; j++){

                int white = 0;
                int black = 0;


                if(grid[i][j] == 'B'){
                    black++;
                }
                else{
                    white++;
                }

                if(grid[i][j+1] == 'B'){
                    black++;
                }
                else{
                    white++;
                }

                if(grid[i+1][j] == 'B'){
                    black++;
                }
                else{
                    white++;
                }

                if(grid[i+1][j+1] == 'B'){
                    black++;
                }
                else{
                    white++;
                }

                if(white==0 || white==1 || black==0 || black==1){
                    return true;
                }
            }
        }

        return false;
    }
}