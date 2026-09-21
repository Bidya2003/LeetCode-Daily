class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int ans = -1;
        int c = Integer.MAX_VALUE;
        for(int i =0; i<capacity.length; i++){
            if(capacity[i] >= itemSize && capacity[i] < c){
                ans = i;
                c = capacity[i];
            }
        }
        return ans;
    }
}