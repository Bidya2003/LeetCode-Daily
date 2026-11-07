
class Solution {
    class Pair {
        int weight;
        int idx;
        long time;

        Pair(int weight, int idx, long time) {
            this.weight = weight;
            this.idx = idx;
            this.time = time;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] ans = new int[tasks.length];

        // Free servers: weight -> index
        PriorityQueue<Pair> free = new PriorityQueue<>((a, b) -> {
            if (a.weight != b.weight) {
                return Integer.compare(a.weight, b.weight);
            }
            return Integer.compare(a.idx, b.idx);
        });

        // Busy servers: free time -> weight -> index
        PriorityQueue<Pair> busy = new PriorityQueue<>((a, b) -> {
            if (a.time != b.time) {
                return Long.compare(a.time, b.time);
            }
            else if (a.weight != b.weight) {
                return Integer.compare(a.weight, b.weight);
            }
            return Integer.compare(a.idx, b.idx);
        });

        for (int i = 0; i < servers.length; i++) {
            free.add(new Pair(servers[i], i, 0));
        }

        long sec = 0;

        for (int j = 0; j < tasks.length; j++) {

            sec = Math.max(sec, j);

            // Move all servers that have become free
            while (!busy.isEmpty() && busy.peek().time <= sec) {
                free.add(busy.remove());
            }

            // If no server is free, wait
            if (free.isEmpty()) {
                sec = busy.peek().time;

                while (!busy.isEmpty() && busy.peek().time <= sec) {
                    free.add(busy.remove());
                }
            }

            // Choose the best free server
            Pair front = free.remove();

            int weight = front.weight;
            int idx = front.idx;

            ans[j] = idx;

            // Server becomes busy again
            busy.add(new Pair(weight, idx, sec + tasks[j]));
        }

        return ans;
    }
}
