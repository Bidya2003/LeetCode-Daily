class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        for(int i=0; i<mat.length; i++){
            
            k = k % mat[i].length;

            if(i % 2 == 0){
                for(int j=0; j<mat[i].length; j++){
                    int now = mat[i][(j+k) % mat[i].length];
                    if(mat[i][j] != now)
                        return false;
                }
            }
            else{
                for(int j=0; j<mat[i].length; j++){
                    int idx = (j - k + mat[i].length) % mat[i].length;
                    if(mat[i][j] != mat[i][idx]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}