// class Solution {
//     class Pair{
//         int row;
//         int col;
//         int cost;
//         int turn;
//         int k;
//         Pair(int row,int col, int cost, int turn, int k){
//             this.row = row;
//             this.col = col;
//             this.cost = cost;
//             this.turn = turn;
//             this.k = k;
//         }
//     }
//     public void checkMinCost(int[][] grid, int[][][][] minCost, int k) {
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
//         pq.add(new Pair(0,0,grid[0][0],-1,k));

//         int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

//         while(!pq.isEmpty()){
//             Pair front = pq.remove();
//             int row = front.row; int col = front.col; int cost = front.cost; int turn = front.turn; int currK = front.k;

//             if (turn != -1 && cost > minCost[row][col][turn][currK])
//                 continue;
            
//             for(int i=0; i<directions.length; i++){
//                 int newRow = row + directions[i][0];
//                 int newCol = col + directions[i][1];              

//                 if(newRow<0 || newCol<0 || newRow>=grid.length || newCol>=grid[0].length)
//                     continue;

//                 int newTurn = i;
//                 int newK = currK;

//                 // First move has no turn
//                 if (turn != -1 && turn != newTurn) {
//                     newK--;
//                 }

//                 if (newK < 0)
//                     continue;

//                 int newCost = cost + grid[newRow][newCol];

//                 if(newCost < minCost[newRow][newCol][newTurn][newK]){
//                     pq.add(new Pair(newRow,newCol,newCost,newTurn,currK));
//                     minCost[newRow][newCol][newTurn][newK] = newCost;
//                 }
//             }
//         }
//     }
//     public int minCost(int[][] grid, int k) {
//         int m = grid.length;
//         int n = grid[0].length;

//         // [row][col][direction][remaining k]
//         int[][][][] minCost =
//             new int[m][n][4][k + 1];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 for (int d = 0; d < 4; d++) {
//                     Arrays.fill(minCost[i][j][d], Integer.MAX_VALUE);
//                 }
//             }
//         }

//         checkMinCost(grid,minCost,k);

//         int ans = Integer.MAX_VALUE;

//         for (int d = 0; d < 4; d++) {
//             for (int turns = 0; turns <= k; turns++) {
//                 ans = Math.min(ans,
//                     minCost[m - 1][n - 1][d][turns]);
//             }
//         }

//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }


class Solution {

    class Pair {
        int row;
        int col;
        int cost;
        int turn;
        int k;

        Pair(int row, int col, int cost, int turn, int k) {
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.turn = turn;
            this.k = k;
        }
    }

    public void checkMinCost(int[][] grid, int[][][][] minCost, int k) {

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        pq.add(new Pair(0, 0, grid[0][0], -1, k));

        int[][] directions = {
            {0, 1},   // 0 = right
            {0, -1},  // 1 = left
            {1, 0},   // 2 = down
            {-1, 0}   // 3 = up
        };

        while (!pq.isEmpty()) {

            Pair front = pq.remove();

            int row = front.row;
            int col = front.col;
            int cost = front.cost;
            int turn = front.turn;
            int currK = front.k;

            if (turn != -1 && cost > minCost[row][col][turn][currK])
                continue;

            for (int i = 0; i < directions.length; i++) {

                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];

                if (newRow < 0 || newCol < 0 ||
                    newRow >= grid.length || newCol >= grid[0].length)
                    continue;

                int newTurn = i;

                // IMPORTANT: every direction gets its own k
                int newK = currK;

                // First move has no turn
                if (turn != -1 && turn != newTurn) {
                    newK--;
                }

                if (newK < 0)
                    continue;

                int newCost = cost + grid[newRow][newCol];

                if (newCost < minCost[newRow][newCol][newTurn][newK]) {

                    minCost[newRow][newCol][newTurn][newK] = newCost;

                    pq.add(new Pair(
                        newRow,
                        newCol,
                        newCost,
                        newTurn,
                        newK
                    ));
                }
            }
        }
    }

    public int minCost(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        if(m==1 && n==1)
            return grid[0][0];
            
        // [row][col][direction][remaining k]
        int[][][][] minCost =
            new int[m][n][4][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    Arrays.fill(minCost[i][j][d], Integer.MAX_VALUE);
                }
            }
        }

        checkMinCost(grid, minCost, k);

        int ans = Integer.MAX_VALUE;

        for (int d = 0; d < 4; d++) {
            for (int turns = 0; turns <= k; turns++) {
                ans = Math.min(ans,
                    minCost[m - 1][n - 1][d][turns]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}