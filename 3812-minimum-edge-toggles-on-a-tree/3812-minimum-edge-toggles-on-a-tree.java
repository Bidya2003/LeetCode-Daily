class Solution {
    class Pair{
        int node;
        int index;
        Pair(int node, int index){
            this.node = node;
            this.index  = index;
        }
    }
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        List<Integer> ans = new ArrayList<>();

        List<List<Pair>> graph =new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1],i));
            graph.get(edges[i][1]).add(new Pair(edges[i][0],i));
        }

        int[] degree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            degree[i] = graph.get(i).size();
            if(degree[i] == 1)
                q.add(i);
        }

        boolean[] usedNode = new boolean[n];
        StringBuilder changableStart = new StringBuilder(start);

        while(!q.isEmpty()){
            int node = q.remove();

            if(degree[node] == 0)
                continue;

            Pair edge = null;
            for(Pair p : graph.get(node)){
                if(usedNode[p.index] == false){
                    edge = p;
                    break;
                }
            }

            if(edge == null)
                continue;

            int edgeNode = edge.node;
            int edgeIndex = edge.index;

            if(changableStart.charAt(node) != target.charAt(node)){
                char c = changableStart.charAt(node);
                changableStart.setCharAt(node, (c=='0')?'1':'0');

                c = changableStart.charAt(edgeNode);
                changableStart.setCharAt(edgeNode, (c=='0')?'1':'0');

                ans.add(edgeIndex);
            }

            usedNode[edgeIndex] = true;

            degree[node]--;
            degree[edgeNode]--;

            if(degree[edgeNode] == 1){
                q.add(edgeNode);
            }
        }

        if(!changableStart.toString().equals(target)){
            return Arrays.asList(-1);
        }

        Collections.sort(ans);

        return ans;
    }
}