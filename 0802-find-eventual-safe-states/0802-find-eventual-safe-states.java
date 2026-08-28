class Solution {
    public List<Integer> topologicalSort(List<List<Integer>> adj, int[] indegree){
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }
        return ans;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        //REVERSE THE GRAPH
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }

        int[] indegree = new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            indegree[i] = graph[i].length;
        }

        List<Integer> ans = topologicalSort(adj,indegree);
        Collections.sort(ans);
        return ans;
    }
}