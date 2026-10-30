class Solution {

    class Pair {
        int end;
        int weight;

        Pair(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    class State {
        int node;
        int total;
        int count;

        State(int node, int total, int count) {
            this.node = node;
            this.total = total;
            this.count = count;
        }
    }

    List<List<Pair>> graph;

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // tor graph creation almost same
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(
                new Pair(edges[i][1], edges[i][2])
            );
        }

        // dist[node][consecutive count]
        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.total, b.total)
        );

        // node 0-er character already ekbar ache
        dist[0][1] = 0;

        pq.add(new State(0, 0, 1));

        while (!pq.isEmpty()) {

            State curr = pq.remove();

            int child = curr.node;
            int total = curr.total;
            int count = curr.count;

            if (total != dist[child][count]) {
                continue;
            }

            // target peyechi
            if (child == n - 1) {
                return total;
            }

            // eta tor ager for loop-er motoi
            for (Pair edge : graph.get(child)) {

                int end = edge.end;
                int weight = edge.weight;

                int newCount;

                // current node and next node-er label same
                if (labels.charAt(child) == labels.charAt(end)) {

                    newCount = count + 1;

                    // k-er beshi consecutive hoye gelo
                    if (newCount > k) {
                        continue;
                    }
                }
                else {
                    // different character, tai count reset
                    newCount = 1;
                }

                int newTotal = total + weight;

                if (newTotal < dist[end][newCount]) {

                    dist[end][newCount] = newTotal;

                    pq.add(
                        new State(end, newTotal, newCount)
                    );
                }
            }
        }

        return -1;
    }
}