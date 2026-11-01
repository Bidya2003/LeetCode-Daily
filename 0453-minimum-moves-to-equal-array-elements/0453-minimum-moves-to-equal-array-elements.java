class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            if(i<min){
                min = i;
            }
        }
        int ans = 0;
        for(int i : nums){
            ans += (i-min);
        }
        return (ans < 0) ? 0 : ans;
    }
}