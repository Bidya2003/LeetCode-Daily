class Solution {
    int minCost = 0;
    public int checkAllNodes(int limit, int root, int[] cost) {
        if(root>limit)
            return cost[root-1];
        
        int left = checkAllNodes(limit,2*root,cost);
        int right = checkAllNodes(limit,2*root+1,cost);

        int diff = Math.abs(left-right);
        minCost += diff;

        return Math.max(left,right) + cost[root-1]; 
    }
    public int minIncrements(int n, int[] cost) {
        int limit = n - ((n+1)/2);

        checkAllNodes(limit,1,cost);
        return minCost;
    }
}