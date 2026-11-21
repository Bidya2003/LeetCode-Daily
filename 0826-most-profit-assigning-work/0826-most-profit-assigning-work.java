class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int m = worker.length;

        Integer[] sortIdx = new Integer[n];

        for(int i=0; i<n; i++){
            sortIdx[i] = i;
        }

        Arrays.sort(sortIdx, (a,b) -> {
            if(difficulty[a] != difficulty[b]){
                return Integer.compare(difficulty[a], difficulty[b]);
            }
            else{
                return Integer.compare(profit[a], profit[b]);
            }
        });

        // CHANGED: Prefix maximum profit
        int[] maxProfit = new int[n];

        maxProfit[0] = profit[sortIdx[0]];

        for(int i = 1; i < n; i++) {
            maxProfit[i] = Math.max(maxProfit[i-1], profit[sortIdx[i]]);
        }

        Arrays.sort(worker);

        int ans = 0;

        int d = n-1;
        int w = m-1;

        while(d>=0 && w>=0){
            if(difficulty[sortIdx[d]] <= worker[w]){
                ans += maxProfit[d];
                w--;
            }
            else{
                d--;
            }
        }

        return ans;
    }
}