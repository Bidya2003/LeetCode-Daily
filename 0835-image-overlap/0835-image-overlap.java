class Solution {

    public List<List<Integer>> findOne(int[][] img) {

        List<List<Integer>> oneCount = new ArrayList<>();

        for(int row = 0; row < img.length; row++) {

            for(int col = 0; col < img[0].length; col++) {

                if(img[row][col] == 1) {

                    List<Integer> temp = new ArrayList<>();

                    temp.add(row);
                    temp.add(col);

                    oneCount.add(temp);
                }
            }
        }

        return oneCount;
    }

    int maxOverLap = 0;

    boolean[][] visited;
    int offset;

    // left, right, top, down
    public void slidingOne(List<List<Integer>> oneCount,
                           int[][] img,
                           int row,
                           int col) {

        // Shift-er boundary
        if(row < -(img.length - 1) || row > img.length - 1 ||
           col < -(img[0].length - 1) || col > img[0].length - 1) {
            return;
        }

        // Same shift abar visit korbo na
        if(visited[row + offset][col + offset]) {
            return;
        }

        visited[row + offset][col + offset] = true;

        int count = 0;

        for(int i = 0; i < oneCount.size(); i++) {

            int nr = oneCount.get(i).get(0) - row;
            int nc = oneCount.get(i).get(1) - col;

            if(nr < 0 || nr >= img.length ||
               nc < 0 || nc >= img[0].length) {
                continue;
            }

            if(img[nr][nc] == 1) {
                count++;
            }
        }

        maxOverLap = Math.max(maxOverLap, count);

        // left
        slidingOne(oneCount, img, row, col - 1);

        // right
        slidingOne(oneCount, img, row, col + 1);

        // top
        slidingOne(oneCount, img, row - 1, col);

        // down
        slidingOne(oneCount, img, row + 1, col);
    }

    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        offset = n - 1;

        visited = new boolean[2 * n - 1][2 * n - 1];

        List<List<Integer>> oneCount1 = findOne(img1);

        slidingOne(oneCount1, img2, 0, 0);

        // New traversal-er jonno visited reset
        visited = new boolean[2 * n - 1][2 * n - 1];

        List<List<Integer>> oneCount2 = findOne(img2);

        slidingOne(oneCount2, img1, 0, 0);

        return maxOverLap;
    }
}