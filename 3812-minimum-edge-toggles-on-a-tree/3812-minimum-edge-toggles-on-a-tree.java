// class Solution {
//     class Pair{
//         int node;
//         int index;
//         Pair(int node, int index){
//             this.node = node;
//             this.index = index;
//         }
//     }
//     public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
//         List<Integer> ans = new ArrayList<>();

//         List<List<Pair>> graph = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             graph.add(new ArrayList<>());
//         }

//         for(int i=0; i<edges.length; i++){
//             graph.get(edges[i][0]).add(new Pair(edges[i][1],i));
//             graph.get(edges[i][1]).add(new Pair(edges[i][0],i));
//         }

//         StringBuilder changableStart = new StringBuilder(start);

//         boolean[] presentInQueue = new boolean[n];

//         Queue<Pair> q = new LinkedList<>();

//         for(int i=0;i<start.length();i++){
//             if(start.charAt(i) != target.charAt(i)){
//                 q.add(new Pair(i,-1));
//                 presentInQueue[i] = true;
//             }
//         }

//         while(!q.isEmpty()){
//             if(changableStart.toString().equals(target))
//                 break;
            
//             Pair front = q.remove();
//             int node = front.node; int index = front.index;

//             if(presentInQueue[node] == false)
//                 continue;
            
//             String place = (changableStart.charAt(node) == '0') ? "1" : "0";
//             changableStart.replace(node,place);

//             for(Pair edge : graph.get(node)){
//                 if(presentInQueue[edge.node] == true){
//                     String place = (changableStart.charAt(edge.node) == '0') ? "1" : "0";
//                     changableStart.replace(edge.node,place);

//                     presentInQueue[edge.node] = false;
//                     ans.add(edge.index);
//                 }
//                 else{
//                     if(target.charAt(edge.node) == start.charAt(edge.node)){
//                         q.add(edge);
//                         presentInQueue[edge.node] = true;
//                         ans.add(edge.index);
//                     }
//                     String place = (changableStart.charAt(edge.node) == '0') ? "1" : "0";
//                     changableStart.replace(edge.node,place);
//                 }
//             }
//         }

//         while(!q.isEmpty()){
//             Pair front = q.remove();

//             String place = (changableStart.charAt(front.node) == '0') ? "1" : "0";
//             changableStart.replace(front.node,place);

//             ans.remove(front.index);
//         }

//         Collections.sort(ans);

//         return ans;
//     }
// }



class Solution {

    class Pair {
        int node;
        int index;

        Pair(int node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public List<Integer> minimumFlips(int n, int[][] edges,
                                      String start, String target) {

        List<Integer> ans = new ArrayList<>();

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(new Pair(v, i));
            graph.get(v).add(new Pair(u, i));
        }

        StringBuilder changableStart = new StringBuilder(start);

        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            degree[i] = graph.get(i).size();
        }

        Queue<Integer> q = new LinkedList<>();

        // Initially all leaf nodes
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }

        boolean[] usedEdge = new boolean[n - 1];

        while (!q.isEmpty()) {

            int node = q.remove();

            if (degree[node] == 0)
                continue;

            Pair edge = null;

            // Find the only remaining edge of this node
            for (Pair p : graph.get(node)) {
                if (!usedEdge[p.index]) {
                    edge = p;
                    break;
                }
            }

            if (edge == null)
                continue;

            int neighbour = edge.node;
            int edgeIndex = edge.index;

            // If node currently doesn't match target,
            // we MUST toggle its only remaining edge.
            if (changableStart.charAt(node) != target.charAt(node)) {

                // toggle node
                char c = changableStart.charAt(node);
                changableStart.setCharAt(
                    node,
                    c == '0' ? '1' : '0'
                );

                // toggle neighbour
                c = changableStart.charAt(neighbour);
                changableStart.setCharAt(
                    neighbour,
                    c == '0' ? '1' : '0'
                );

                ans.add(edgeIndex);
            }

            usedEdge[edgeIndex] = true;

            degree[node]--;
            degree[neighbour]--;

            if (degree[neighbour] == 1) {
                q.add(neighbour);
            }
        }

        if (!changableStart.toString().equals(target)) {
            return Arrays.asList(-1);
        }

        Collections.sort(ans);

        return ans;
    }
}