class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for(int i=0;i<n;i++){
            graph.get(favorite[i]).add(i);
            indegree[favorite[i]]++;
        }

        int[] depth = new int[n];
        Arrays.fill(depth,1);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int front = q.remove();

            int next = favorite[front];
            depth[next] = Math.max(depth[next], depth[front]+1);

            indegree[next]--;

            if(indegree[next]==0){
                q.add(next);
            }
        }

        boolean[] visited = new boolean[n];
        int maxCycle = 0;
        int pairChains = 0;
        for(int i=0;i<n;i++){
            int current = i;

            if(indegree[current]==0 || visited[current]){
                continue;
            }

            int cycleLength = 0;
            while(!visited[current]){
                cycleLength++;
                visited[current] = true;
                current = favorite[current];
            }

            if(cycleLength == 2){
                int a = current;
                int b = favorite[current];

                pairChains += depth[a] + depth[b];
            }
            else{
                maxCycle = Math.max(maxCycle,cycleLength);
            }
        }


        return Math.max(maxCycle,pairChains);
    }
}