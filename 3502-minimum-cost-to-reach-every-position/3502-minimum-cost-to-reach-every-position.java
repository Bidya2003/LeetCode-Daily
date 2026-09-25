class Solution {
    public int[] minCosts(int[] cost) {
        int min = Integer.MAX_VALUE;

        for(int i=0; i<cost.length; i++){
            if(min < cost[i]){
                cost[i]=min;
            }
            else{
                min = Math.min(min, cost[i]);
            }
        }

        return cost;
    }
}