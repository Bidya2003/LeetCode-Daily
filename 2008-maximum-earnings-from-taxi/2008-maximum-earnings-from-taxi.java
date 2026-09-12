class Solution {
    long[] dp;
    int[] next;
    public long findMaxTaxiEarnings(int[][] rides, int idx){
        if(idx==rides.length){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        long skip = findMaxTaxiEarnings(rides,idx+1);
        long take = (rides[idx][1] - rides[idx][0] + rides[idx][2]) + findMaxTaxiEarnings(rides,next[idx]);

        return dp[idx] = Math.max(take,skip);
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b)-> Integer.compare(a[0],b[0]));

        next = new int[rides.length];
        for(int i=0;i<rides.length;i++){
            int left = i+1;
            int right = rides.length-1;
            int ans = rides.length;

            while(left<=right){
                int mid = left + (right - left) / 2;
                if(rides[mid][0] >= rides[i][1]){
                    ans = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            next[i] = ans;
        }

        dp = new long[rides.length];
        Arrays.fill(dp,-1);

        return findMaxTaxiEarnings(rides,0);
    }
}