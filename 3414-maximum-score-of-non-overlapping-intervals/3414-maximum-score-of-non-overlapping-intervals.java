class Solution {

    class Track {
        int start;
        int end;
        int weight;
        int index;

        Track(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    class Pair {
        long score;
        List<Integer> ans;

        Pair(long score, List<Integer> ans) {
            this.score = score;
            this.ans = ans;
        }
    }

    Pair[][] dp;
    int[] next;

    public Pair calculateMaximumWeight(List<Track> graph, int i, int indices) {

        if (indices == 0 || i >= graph.size()) {
            return new Pair(0, new ArrayList<>());
        }

        if (dp[i][indices] != null) {
            return dp[i][indices];
        }

        // Skip
        Pair skip = calculateMaximumWeight(graph, i + 1, indices);

        // Take
        Pair take = calculateMaximumWeight(
            graph,
            next[i],
            indices - 1
        );

        long takeScore = graph.get(i).weight + take.score;

        List<Integer> takeAns = new ArrayList<>(take.ans);
        takeAns.add(graph.get(i).index);

        List<Integer> skipAns = new ArrayList<>(skip.ans);

        Collections.sort(takeAns);
        Collections.sort(skipAns);

        Pair result;

        if (takeScore > skip.score) {
            result = new Pair(takeScore, takeAns);
        }
        else if (takeScore < skip.score) {
            result = new Pair(skip.score, skipAns);
        }
        else {
            if (isSmaller(takeAns, skipAns)) {
                result = new Pair(takeScore, takeAns);
            }
            else {
                result = new Pair(skip.score, skipAns);
            }
        }

        dp[i][indices] = result;

        return result;
    }

    public boolean isSmaller(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        List<Track> graph = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            graph.add(new Track(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            ));
        }

        Collections.sort(graph, (a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }

            return Integer.compare(a.end, b.end);
        });

        int n = graph.size();

        next = new int[n];

        // Precompute next compatible interval
        for (int i = 0; i < n; i++) {

            int left = i + 1;
            int right = n - 1;
            int ans = n;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (graph.get(mid).start > graph.get(i).end) {
                    ans = mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            next[i] = ans;
        }

        dp = new Pair[n][5];

        Pair ans = calculateMaximumWeight(graph, 0, 4);

        Collections.sort(ans.ans);

        int[] ansArr = new int[ans.ans.size()];

        for (int i = 0; i < ans.ans.size(); i++) {
            ansArr[i] = ans.ans.get(i);
        }

        return ansArr;
    }
}