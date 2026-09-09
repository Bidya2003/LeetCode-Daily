class Solution {

    public int maximumInvitations(int[] favorite) {

        int n = favorite.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
            graph.get(favorite[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // longest chain ending at each node
        int[] depth = new int[n];

        Arrays.fill(depth, 1);

        // Topological Sort
        while (!q.isEmpty()) {

            int front = q.remove();

            int next = favorite[front];

            // front -> next
            depth[next] = Math.max(depth[next], depth[front] + 1);

            indegree[next]--;

            if (indegree[next] == 0) {
                q.add(next);
            }
        }

        int maxCycle = 0;
        int pairChains = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            // cycle-এর মধ্যে নেই
            if (indegree[i] == 0 || visited[i]) {
                continue;
            }

            int current = i;
            int cycleLen = 0;

            while (!visited[current]) {

                visited[current] = true;

                cycleLen++;

                current = favorite[current];
            }

            if (cycleLen == 2) {

                int a = i;
                int b = favorite[i];

                // দুই side-এর longest chain + 2 cycle nodes
                pairChains += depth[a] + depth[b];

            } else {

                maxCycle = Math.max(maxCycle, cycleLen);
            }
        }

        return Math.max(maxCycle, pairChains);
    }
}

