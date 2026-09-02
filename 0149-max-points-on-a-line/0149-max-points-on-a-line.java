// class Solution {
//     public int checkPoints(int[][] grid, int row, int col, int diffRow, int diffCol){
//         if(row<0 || col<0 || row>=grid.length || col>=grid[0].length)
//             return 0;

//         int add = 0;
//         if(grid[row][col]==1)
//             add = 1;
        
//         return add + checkPoints(grid, row+diffRow, col+diffCol, diffRow, diffCol);
//     }

//     public int maxPoints(int[][] points) {
//         if(points.length == 1)
//             return 1;

//         int n = -1;
//         int m = -1;
//         int base = Integer.MAX_VALUE;
//         for(int i=0; i<points.length; i++){
//             n = Math.max(n,points[i][0]);
//             m = Math.max(m,points[i][1]);
//             base = Math.min(base, Math.min(points[i][0], points[i][1]));
//         }

//         if(base<0)
//             base = -base;
//         else
//             base = 0;

//         int[][] grid = new int[n+base+1][m+base+1];
//         for(int[] arr : grid){
//             Arrays.fill(arr, -1);
//         }
//         for(int i=0; i<points.length; i++){
//             int row = points[i][0] + base; 
//             int col = points[i][1] + base;
//             grid[row][col] = 1 ;
//         }

//         Arrays.sort(points, (a,b) -> {
//             if(a[0] != b[0])
//                 return Integer.compare(a[0],b[0]);
//             else
//                 return Integer.compare(a[1],b[1]);
//         });

//         int max = Integer.MIN_VALUE;
//         for(int i=0; i<points.length; i++){
//             for(int j=i+1; j<points.length; j++){
//                 int row = points[j][0] + base; int col =points[j][1] + base;

//                 int diffRow = row - (points[i][0] + base);
//                 int diffCol = col - (points[i][1] + base);
//                 int diff = 0;
//                 if(diffCol==0 || diffRow==0){
//                     if(diffCol==0)
//                         diffRow = 1;
//                     if(diffRow==0)
//                         diffCol = 1;
//                 }
//                 else if(diffCol > diffRow){
//                     diff = diffCol/diffRow;
//                     diffRow = 1;
//                     diffCol = diff;
//                 }
//                 else if(diffCol < diffRow){
//                     diff = diffRow/diffCol;
//                     diffCol = 1;
//                     diffCol = diff;
//                 }
//                 else{
//                     diffRow = 1;
//                     diffCol = 1;
//                 }

//                 int temp = 1 + checkPoints(grid,row,col,diffRow,diffCol);

//                 max = Math.max(max,temp);
//             }
//         }

//         return max;
//     }
// }


// class Solution {

//     public int gcd(int a, int b) {
//         a = Math.abs(a);
//         b = Math.abs(b);

//         while (b != 0) {
//             int temp = a % b;
//             a = b;
//             b = temp;
//         }

//         return a;
//     }

//     public int checkPoints(int[][] grid, int row, int col,
//                            int diffRow, int diffCol) {

//         if (row < 0 || col < 0 ||
//             row >= grid.length || col >= grid[0].length) {
//             return 0;
//         }

//         int add = 0;

//         if (grid[row][col] == 1)
//             add = 1;

//         return add + checkPoints(
//             grid,
//             row + diffRow,
//             col + diffCol,
//             diffRow,
//             diffCol
//         );
//     }

//     public int maxPoints(int[][] points) {

//         if (points.length == 1)
//             return 1;

//         int n = -1;
//         int m = -1;
//         int base = Integer.MAX_VALUE;

//         for (int i = 0; i < points.length; i++) {

//             n = Math.max(n, points[i][0]);
//             m = Math.max(m, points[i][1]);

//             base = Math.min(
//                 base,
//                 Math.min(points[i][0], points[i][1])
//             );
//         }

//         if (base < 0)
//             base = -base;
//         else
//             base = 0;

//         int[][] grid = new int[n + base + 1][m + base + 1];

//         for (int[] arr : grid) {
//             Arrays.fill(arr, -1);
//         }

//         for (int i = 0; i < points.length; i++) {

//             int row = points[i][0] + base;
//             int col = points[i][1] + base;

//             grid[row][col] = 1;
//         }

//         Arrays.sort(points, (a, b) -> {

//             if (a[0] != b[0])
//                 return Integer.compare(a[0], b[0]);

//             return Integer.compare(a[1], b[1]);
//         });

//         int max = 1;

//         for (int i = 0; i < points.length; i++) {

//             for (int j = i + 1; j < points.length; j++) {

//                 int row1 = points[i][0] + base;
//                 int col1 = points[i][1] + base;

//                 int row2 = points[j][0] + base;
//                 int col2 = points[j][1] + base;

//                 int diffRow = row2 - row1;
//                 int diffCol = col2 - col1;

//                 // Normalize direction using GCD
//                 int gcd = gcd(diffRow, diffCol);

//                 diffRow /= gcd;
//                 diffCol /= gcd;

//                 // Start from point i, not point j
//                 int temp = checkPoints(
//                     grid,
//                     row1,
//                     col1,
//                     diffRow,
//                     diffCol
//                 );

//                 max = Math.max(max, temp);
//             }
//         }

//         return max;
//     }
// }




class Solution {

    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public int checkPoints(int[][] points,
                           int row, int col,
                           int diffRow, int diffCol) {

        int count = 0;

        for (int i = 0; i < points.length; i++) {

            int r = points[i][0];
            int c = points[i][1];

            int dr = r - row;
            int dc = c - col;

            // Same line + correct direction
            if (dr * diffCol == dc * diffRow &&
                dr * diffRow >= 0 &&
                dc * diffCol >= 0) {

                count++;
            }
        }

        return count;
    }

    public int maxPoints(int[][] points) {

        if (points.length <= 2)
            return points.length;

        int max = 1;

        for (int i = 0; i < points.length; i++) {

            for (int j = i + 1; j < points.length; j++) {

                int diffRow = points[j][0] - points[i][0];
                int diffCol = points[j][1] - points[i][1];

                int gcd = gcd(diffRow, diffCol);

                diffRow /= gcd;
                diffCol /= gcd;

                int temp = checkPoints(
                    points,
                    points[i][0],
                    points[i][1],
                    diffRow,
                    diffCol
                );

                max = Math.max(max, temp);
            }
        }

        return max;
    }
}