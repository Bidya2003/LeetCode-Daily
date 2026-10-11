class Solution {
    public boolean checkValid(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            boolean[] row = new boolean[matrix.length+1];
            boolean[] col = new boolean[matrix.length+1];

            for(int j=0; j<matrix.length; j++){

                //Row chcek
                if(row[matrix[i][j]])
                    return false;
                row[matrix[i][j]] = true;

                //Column check
                if(col[matrix[j][i]])
                    return false;
                col[matrix[j][i]] = true;
            }
        }

        return true;
    }
}