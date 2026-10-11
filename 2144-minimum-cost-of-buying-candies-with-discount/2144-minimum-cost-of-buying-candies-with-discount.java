class Solution {
    public int minimumCost(int[] cost) {
        int free = 0;
        int total = 0;
        Arrays.sort(cost);

        for(int i=cost.length-1; i>=0; i--){
            if(free == 2){
                free = 0;
                continue;
            }
            else{
                free++;
                total += cost[i];
            }
        }

        return total;
    }
}