
class Solution {
    class Pair {
        int server;
        int time;

        Pair(int server, int time) {
            this.server = server;
            this.time = time;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        PriorityQueue<Pair> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.time, b.time)
        );

        TreeSet<Integer> free = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        int[] servers = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            // Release all servers whose tasks are finished
            while (!busy.isEmpty() &&
                   busy.peek().time <= arrival[i]) {

                free.add(busy.poll().server);
            }

            if (free.isEmpty()) {
                continue;
            }

            // Find first available server from i % k
            Integer server = free.ceiling(i % k);

            // If not found, wrap around to smallest index
            if (server == null) {
                server = free.first();
            }

            free.remove(server);

            servers[server]++;

            busy.add(new Pair(server, arrival[i] + load[i]));
        }

        int max = 0;

        for (int num : servers) {
            max = Math.max(max, num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (servers[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
