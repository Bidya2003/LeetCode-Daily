class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        for(int col=0; col<matrix[0].length; col++){
            List<Integer> minusOneRow = new ArrayList<>();
            int maxVal = Integer.MIN_VALUE;

            for(int row =0; row<matrix.length; row++){
                maxVal = Math.max(maxVal,matrix[row][col]);
                if(matrix[row][col] == -1){
                    minusOneRow.add(row);
                }
            }

            for(int i : minusOneRow){
                matrix[i][col] = maxVal;
            }
        }

        return matrix;
    }
}