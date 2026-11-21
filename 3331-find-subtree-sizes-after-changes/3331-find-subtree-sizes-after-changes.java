/*

class Solution {
    class Pair {
        int node;
        int sub;

        Pair(int node, int sub) {
            this.node = node;
            this.sub = sub;
        }
    }

    int[] ans;

    public int subtreeCount(Map<Integer, List<Integer>> decendants, int node) {

        int subtree = 1;

        if(!decendants.containsKey(node)) {
            return ans[node] = 1;
        }

        for(int i : decendants.get(node)) {
            subtree += subtreeCount(decendants, i);
        }

        return ans[node] = subtree;
    }

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        // Store final parent of every node
        int[] newParent = parent.clone();

        for(int i = 1; i < n; i++) {

            int curr = parent[i];

            while(curr != -1) {

                if(s.charAt(curr) == s.charAt(i)) {
                    newParent[i] = curr;
                    break;
                }

                curr = parent[curr];
            }
        }

        // Build final tree
        Map<Integer, List<Integer>> updated = new HashMap<>();

        for(int i = 1; i < n; i++) {
            updated.computeIfAbsent(newParent[i], k -> new ArrayList<>());
            updated.get(newParent[i]).add(i);
        }

        ans = new int[n];

        subtreeCount(updated, 0);

        return ans;
    }
}
*/



class Solution {

    class Pair {
        int node;
        int sub;

        Pair(int node, int sub) {
            this.node = node;
            this.sub = sub;
        }
    }

    int[] ans;

    public int subtreeCount(Map<Integer, List<Integer>> decendants, int node) {

        int subtree = 1;

        if(!decendants.containsKey(node)) {
            return ans[node] = 1;
        }

        for(int i : decendants.get(node)) {
            subtree += subtreeCount(decendants, i);
        }

        return ans[node] = subtree;
    }

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        // Store final parent of every node
        int[] newParent = parent.clone();

        // Build original tree
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 1; i < n; i++) {
            adj.computeIfAbsent(parent[i], k -> new ArrayList<>());
            adj.get(parent[i]).add(i);
        }

        // Find closest same-character ancestor
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] oldLast = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(0);

        while(!st.isEmpty()) {

            int node = st.pop();

            if(node < 0) {

                node = ~node;

                int c = s.charAt(node) - 'a';

                last[c] = oldLast[node];

                continue;
            }

            int c = s.charAt(node) - 'a';

            oldLast[node] = last[c];

            if(last[c] != -1) {
                newParent[node] = last[c];
            }

            last[c] = node;

            st.push(~node);

            if(adj.containsKey(node)) {
                for(int child : adj.get(node)) {
                    st.push(child);
                }
            }
        }

        // Build final tree
        Map<Integer, List<Integer>> updated = new HashMap<>();

        for(int i = 1; i < n; i++) {
            updated.computeIfAbsent(newParent[i], k -> new ArrayList<>());
            updated.get(newParent[i]).add(i);
        }

        ans = new int[n];

        subtreeCount(updated, 0);

        return ans;
    }
}

