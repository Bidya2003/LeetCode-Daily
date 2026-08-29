class Solution {
    class Pair{
        int row;
        int col;
        int len;
        Pair(int row, int col, int len){
            this.row = row;
            this.col = col;
            this.len = len;
        }
    }
    public void findLongestIncreasingPath(int[][] matrix, int[][] trackLen) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.len,a.len));
        pq.add(new Pair(0,0,1));
        trackLen[0][0] = 1;

        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};

        while(!pq.isEmpty()){
            Pair front = pq.remove();
            int row = front.row; int col = front.col; int len = front.len;

            if(trackLen[row][col]>len) continue;

            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow<0 || newCol<0 || newRow>=matrix.length || newCol>=matrix[0].length) continue;
                
                int newLen = 1;
                if(matrix[newRow][newCol] > matrix[row][col]){
                    newLen = len+1;
                }

                if(trackLen[newRow][newCol] < newLen){
                    pq.add(new Pair(newRow,newCol,newLen));
                    trackLen[newRow][newCol] = newLen;
                }
            }
        }
    }
    public int longestIncreasingPath(int[][] matrix) {
        int[][] trackLen = new int[matrix.length][matrix[0].length];
        for(int[] arr : trackLen){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }

        findLongestIncreasingPath(matrix,trackLen);
        int max = Integer.MIN_VALUE;

        for(int i=0; i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max,trackLen[i][j]);
            }
        }

        return max;
    }
}