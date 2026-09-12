class Solution {
    class Track{
        int start;
        int end;
        int profit;
        Track(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    int[] dp;
    int[] next;

    public int findMaxProfitjobScheduling(List<Track> graph, int idx){
        if(idx==graph.size())
            return 0;

        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int skip = findMaxProfitjobScheduling(graph,idx+1);
        int take = graph.get(idx).profit + findMaxProfitjobScheduling(graph,next[idx]);

        return dp[idx] = Math.max(take,skip);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Track> graph = new ArrayList<>();

        for(int i=0;i<startTime.length;i++){
            graph.add(new Track(startTime[i],
                                endTime[i],
                                profit[i]));
        }

        Collections.sort(graph, (a,b)->Integer.compare(a.start,b.start));

        next = new int[graph.size()];
        for(int i=0;i<graph.size();i++){
            int left = i+1;
            int right = graph.size()-1;
            int n = graph.size();

            while(left<=right){
                int mid = left + (right - left) / 2;

                if(graph.get(mid).start >= graph.get(i).end){
                    n = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }

            next[i] = n;
        }

        dp = new int[graph.size()];
        Arrays.fill(dp,-1);

        return findMaxProfitjobScheduling(graph,0);

    }
}