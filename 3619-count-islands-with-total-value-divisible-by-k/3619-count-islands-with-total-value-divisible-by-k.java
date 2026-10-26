class Solution {
    class Pair{
        int row;
        int col;
        int val;
        Pair(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int countIslands(int[][] grid, int k) {
        Queue<Pair> pq = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int[][] dimensions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(visited[i][j] == false && grid[i][j] != 0){
                    visited[i][j] = true;
                    pq.add(new Pair(i, j, grid[i][j]));

                    long sum = 0;

                    while(!pq.isEmpty()){
                        Pair front = pq.remove();
                        int row = front.row; int col = front.col; int val = front.val;

                        sum += val;

                        for(int[] dim : dimensions){
                            int newRow = row + dim[0];
                            int newCol = col + dim[1];

                            if(newRow<0 || newCol<0 || newRow >= grid.length || newCol >= grid[0].length || visited[newRow][newCol] == true || grid[newRow][newCol] == 0)
                                continue;

                            pq.add(new Pair(newRow,newCol,grid[newRow][newCol]));
                            visited[newRow][newCol] = true;
                        }
                    }

                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}