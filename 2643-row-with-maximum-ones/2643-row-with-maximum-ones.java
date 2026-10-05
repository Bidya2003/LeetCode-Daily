class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ans = -1;
        int maxOne = Integer.MIN_VALUE;

        for(int i=0; i<mat.length; i++){
            int total = 0;

            for(int n : mat[i]){
                if(n == 1)
                    total++;
            }

            if(maxOne < total){
                maxOne = total;
                ans = i;
            }
        }

        int[] res = new int[2];
        res[0] = ans;
        res[1] = maxOne;

        return res;
    }
}