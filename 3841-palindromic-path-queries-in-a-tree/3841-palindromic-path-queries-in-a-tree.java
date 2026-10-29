/*

//BRUTE FORCE ( TIME LIMIT EXCEEDED (987 / 1040 testcases passed))

class Solution {

    List<List<Integer>> graph;
    String arranged;

    public void reArrangePath(String str, StringBuilder curr,
                              int idx, int target, int parent) {

        // target already curr-er moddhe add hoye geche
        if (idx == target) {
            arranged = curr.toString();
            return;
        }

        // path already found
        if (!arranged.isEmpty()) {
            return;
        }

        for (int num : graph.get(idx)) {

            // undirected graph-e parent-er dike abar jabo na
            if (num == parent) {
                continue;
            }

            curr.append(str.charAt(num));

            reArrangePath(str, curr, num, target, idx);

            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges,
                                        String s, String[] queries) {

        List<Boolean> ans = new ArrayList<>();

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // graph create
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < queries.length; i++) {

            int blank = 0;
            String curr = "";

            String form = "";
            int first = 0;

            // query parse
            for (int c = 0; c < queries[i].length(); c++) {

                if (queries[i].charAt(c) == ' ') {

                    blank++;

                    if (blank == 1) {
                        form = curr;
                    }
                    else if (blank == 2) {
                        first = Integer.parseInt(curr);
                    }

                    curr = "";
                }
                else {
                    curr = curr + queries[i].charAt(c);
                }
            }

            // update query
            if (form.equals("update")) {

                str.replace(first, first + 1, curr);
            }

            // palindrome query
            else {

                arranged = "";

                int target = Integer.parseInt(curr);

                reArrangePath(
                    str.toString(),
                    new StringBuilder(
                        Character.toString(str.charAt(first))
                    ),
                    first,
                    target,
                    -1
                );

                Map<Character, Integer> map = new HashMap<>();

                for (char ch : arranged.toCharArray()) {
                    map.put(
                        ch,
                        map.getOrDefault(ch, 0) + 1
                    );
                }

                int odd = 0;

                // Character, int na
                for (char key : map.keySet()) {

                    if (map.get(key) % 2 != 0) {
                        odd++;
                    }
                }

                // maximum 1 ta odd frequency hole
                // rearrange kore palindrome possible
                if (odd > 1) {
                    ans.add(false);
                }
                else {
                    ans.add(true);
                }
            }
        }

        return ans;
    }
}
*/

//SEGMENT TREE APPROACH

class Solution {

    List<List<Integer>> graph;

    int[] parent;
    int[] depth;
    int[] size;
    int[] heavy;

    int[] head;
    int[] pos;

    int currentPos;

    char[] chars;

    int[] segTree;

    // ---------------- DFS 1 ----------------

    public int dfs(int node, int par) {

        parent[node] = par;
        size[node] = 1;

        int maxSize = 0;

        for (int next : graph.get(node)) {

            if (next == par) {
                continue;
            }

            depth[next] = depth[node] + 1;

            int childSize = dfs(next, node);

            size[node] += childSize;

            if (childSize > maxSize) {
                maxSize = childSize;
                heavy[node] = next;
            }
        }

        return size[node];
    }


    // ---------------- HLD ----------------

    public void decompose(int node, int h) {

        head[node] = h;
        pos[node] = currentPos++;

        // heavy child same chain-e thakbe
        if (heavy[node] != -1) {
            decompose(heavy[node], h);
        }

        for (int next : graph.get(node)) {

            if (next == parent[node] || next == heavy[node]) {
                continue;
            }

            // light child -> new chain
            decompose(next, next);
        }
    }


    // ---------------- SEGMENT TREE ----------------

    public void build(int node, int left, int right) {

        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);
    }


    public void update(int node, int left, int right,
                       int index, int value) {

        if (left == right) {
            segTree[node] = value;
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        }
        else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        segTree[node] =
            segTree[node * 2] ^ segTree[node * 2 + 1];
    }


    public int querySegment(int node, int left, int right,
                            int ql, int qr) {

        if (qr < left || right < ql) {
            return 0;
        }

        if (ql <= left && right <= qr) {
            return segTree[node];
        }

        int mid = left + (right - left) / 2;

        return querySegment(
                    node * 2,
                    left,
                    mid,
                    ql,
                    qr
               )
               ^
               querySegment(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    ql,
                    qr
               );
    }


    // ---------------- PATH QUERY ----------------

    public int pathQuery(int u, int v, int n) {

        int mask = 0;

        while (head[u] != head[v]) {

            // deeper chain-ke up korbo
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            mask ^= querySegment(
                1,
                0,
                n - 1,
                pos[head[u]],
                pos[u]
            );

            u = parent[head[u]];
        }

        // ekhon same chain
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        mask ^= querySegment(
            1,
            0,
            n - 1,
            pos[u],
            pos[v]
        );

        return mask;
    }


    public List<Boolean> palindromePath(
        int n,
        int[][] edges,
        String s,
        String[] queries
    ) {

        List<Boolean> ans = new ArrayList<>();

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];

        head = new int[n];
        pos = new int[n];

        Arrays.fill(heavy, -1);

        // root = 0
        dfs(0, -1);

        currentPos = 0;

        decompose(0, 0);


        chars = s.toCharArray();

        segTree = new int[4 * n];

        build(1, 0, n - 1);


        // Initial characters segment tree-e add
        for (int i = 0; i < n; i++) {

            int mask =
                1 << (chars[i] - 'a');

            update(
                1,
                0,
                n - 1,
                pos[i],
                mask
            );
        }


        // Queries
        for (String q : queries) {

            String[] parts = q.split(" ");

            // ---------------- UPDATE ----------------

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);

                char c = parts[2].charAt(0);

                chars[u] = c;

                int mask =
                    1 << (c - 'a');

                update(
                    1,
                    0,
                    n - 1,
                    pos[u],
                    mask
                );
            }

            // ---------------- QUERY ----------------

            else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask =
                    pathQuery(u, v, n);

                // 0 or exactly one odd-frequency character
                if (
                    mask == 0 ||
                    (mask & (mask - 1)) == 0
                ) {
                    ans.add(true);
                }
                else {
                    ans.add(false);
                }
            }
        }

        return ans;
    }
}