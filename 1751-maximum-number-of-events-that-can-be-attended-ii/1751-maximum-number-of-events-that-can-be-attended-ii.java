class Solution {
    int[][] dp;
    int[] next;
    public int findMaxTwoEvents(int[][] events, int idx, int atMost){
        if(idx==events.length || atMost==0){
            return 0;
        }

        if(dp[idx][atMost] != -1){
            return dp[idx][atMost];
        }

        int skip = findMaxTwoEvents(events,idx+1,atMost);
        int take = events[idx][2] + findMaxTwoEvents(events,next[idx],atMost-1);

        return dp[idx][atMost] = Math.max(skip,take);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b)->Integer.compare(a[0],b[0]));

        next = new int[events.length];
        for(int i=0;i<events.length;i++){
            int left = i+1;
            int right = events.length-1;
            int n = events.length;

            while(left<=right){
                int mid = left + (right - left) / 2;

                if(events[mid][0] > events[i][1]){
                    n = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            next[i] = n;
        }

        dp = new int[events.length][k+1];
        for(int i=0;i<events.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return findMaxTwoEvents(events,0,k);
    }
    
}