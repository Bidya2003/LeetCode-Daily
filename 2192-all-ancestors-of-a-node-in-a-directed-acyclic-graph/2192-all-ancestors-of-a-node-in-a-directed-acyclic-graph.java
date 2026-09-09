class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();

        List<List<Integer>> sameDirectionGraph = new ArrayList<>();
        List<List<Integer>> oppositeDirectionGraph = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i=0;i<n;i++){
            sameDirectionGraph.add(new ArrayList<>());
            oppositeDirectionGraph.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0]; int to = edges[i][1];
            sameDirectionGraph.get(from).add(to);
            oppositeDirectionGraph.get(to).add(from);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int front = q.remove();

            for(int ancestor : oppositeDirectionGraph.get(front)){
                if(!ans.get(front).contains(ancestor))
                    ans.get(front).add(ancestor);
                
                for(int ancesAnces : ans.get(ancestor)){
                    if(!ans.get(front).contains(ancesAnces))
                        ans.get(front).add(ancesAnces);
                }
            }
            Collections.sort(ans.get(front));

            for(int decendant : sameDirectionGraph.get(front)){
                indegree[decendant]--;

                if(indegree[decendant]==0){
                    q.add(decendant);
                }
            }
        }
        return ans;
    }
}