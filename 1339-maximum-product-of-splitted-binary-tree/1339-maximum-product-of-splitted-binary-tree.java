class Solution {

    class Pair {
        List<TreeNode> next;
        int edgesCount;

        Pair(List<TreeNode> next, int edgesCount) {
            this.next = next;
            this.edgesCount = edgesCount;
        }
    }

    Map<TreeNode, Pair> map = new HashMap<>();
    Map<TreeNode, Integer> total = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();

    public void setMap(TreeNode root) {

        if(root == null)
            return;

        if(!total.containsKey(root)) {
            total.put(root, -1);
        }

        if(root.left == null && root.right == null) {
            q.add(root);
            return;
        }

        if(root.left != null) {

            map.get(root).next.add(root.left);
            map.get(root).edgesCount++;

            map.put(root.left, new Pair(new ArrayList<>(), 0));

            map.get(root.left).next.add(root);
            map.get(root.left).edgesCount++;

            setMap(root.left);
        }

        if(root.right != null) {

            map.get(root).next.add(root.right);
            map.get(root).edgesCount++;

            map.put(root.right, new Pair(new ArrayList<>(), 0));

            map.get(root.right).next.add(root);
            map.get(root.right).edgesCount++;

            setMap(root.right);
        }
    }

    public int maxProduct(TreeNode root) {

        map.put(root, new Pair(new ArrayList<>(), 0));

        setMap(root);

        while(!q.isEmpty()) {

            TreeNode front = q.remove();

            long sum = front.val;
            Pair curr = map.get(front);

            for(TreeNode i : curr.next) {

                if(total.get(i) != -1) {
                    sum += total.get(i);
                }
                else {

                    int c = map.get(i).edgesCount;

                    map.get(i).edgesCount--;

                    if(i!=root && c - 1 == 1) {
                        q.add(i);
                    }
                }
            }

            total.put(front, (int)sum);
        }

        long full = root.val;
        for(TreeNode i : map.get(root).next){
            full += total.get(i);
        }

        long maxProduct = -1;
        long product;

        for(TreeNode keys : total.keySet()) {

            long curr = total.get(keys);

            product = curr * (full - curr);

            maxProduct = Math.max(maxProduct, product);
        }

        return (int)(maxProduct % 1000000007);
    }
}