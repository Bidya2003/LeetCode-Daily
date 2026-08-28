/*
class Solution {
    class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public List<Integer> topologicalSort(List<List<Integer>> graph, int n){
        List<Integer> ans = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int height = 0;
            q.add(new Pair(i,-1));

            while(!q.isEmpty()){
                int size = q.size();
                for(int j=0;j<size;j++){
                    Pair front = q.remove();
                    for(int child: graph.get(front.node)){
                        if(child == front.parent)
                            continue;
                        q.add(new Pair(child,front.node));
                    }
                }
                height++;                
            }
            System.out.println("i " + i + " height " + height);
            if(height<=min){
                if(height<min) ans.clear();
                ans.add(i);
                min = height;
            }
        }
        return ans;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length==1){
            List<Integer> ans = new ArrayList<>();

            for(int x : edges[0]) {
                ans.add(x);
            }
            return ans;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int[] indegree = new int[n];

        for(int i=0;i<edges.length;i++){
            indegree[edges[i][1]]++;
            indegree[edges[i][0]]++;
        }

        return topologicalSort(graph,n);
    }
}
*/



class Solution {
    public List<Integer> topologicalSort(List<List<Integer>> graph, int[] indegree, int n){
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }
        int remaining = n;
        while(remaining>2){
            int size = q.size();
            remaining -= size;

            for(int i=0;i<size;i++){
                int front = q.remove();
                for(int child : graph.get(front)){
                    indegree[child]--;
                    if(indegree[child]==1){
                        q.add(child);
                    }
                }
            }
        }

        while(!q.isEmpty()){
            ans.add(q.remove());
        }

        return ans;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int[] indegree = new int[n];

        for(int i=0;i<edges.length;i++){
            indegree[edges[i][1]]++;
            indegree[edges[i][0]]++;
        }

        return topologicalSort(graph,indegree,n);
    }
}