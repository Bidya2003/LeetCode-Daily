class Solution {
    int[] dp;
    int[] next;
    public int findMaximizeTheProfit(List<List<Integer>> offers, int idx){
        if(idx == offers.size()){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int skip = findMaximizeTheProfit(offers,idx+1);
        int take = offers.get(idx).get(2) + findMaximizeTheProfit(offers,next[idx]);

        return dp[idx] = Math.max(skip,take);
    }
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a,b)->Integer.compare(a.get(0),b.get(0)));

        next = new int[offers.size()];
        for(int i=0;i<offers.size();i++){
            int left = i+1;
            int right = offers.size()-1;

            int ans = offers.size();
            while(left<=right){
                int mid = left + (right -left) / 2;
                if(offers.get(mid).get(0) > offers.get(i).get(1)){
                    ans = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            next[i] = ans;
        }

        dp = new int[offers.size()];
        Arrays.fill(dp,-1);

        return findMaximizeTheProfit(offers,0);
    }
}