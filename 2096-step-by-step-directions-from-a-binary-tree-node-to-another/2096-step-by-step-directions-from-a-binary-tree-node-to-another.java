/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<Pair> startPath = new ArrayList<>();
    List<Pair> destPath = new ArrayList<>();

    boolean findStart = false;
    boolean findDest = false;

    class Pair {
        int node;
        String dir;

        Pair(int node, String dir) {
            this.node = node;
            this.dir = dir;
        }
    }

    public void getShortestPath(TreeNode root, int startValue, int destValue) {

        if(root == null) return;

        // Current node is start
        if(!findStart && root.val == startValue) {
            startPath.add(new Pair(root.val, "X"));
            findStart = true;
        }

        // Current node is destination
        if(!findDest && root.val == destValue) {
            destPath.add(new Pair(root.val, "X"));
            findDest = true;
        }

        // Leaf
        if(root.left == null && root.right == null) {
            return;
        }

        // Left
        if(root.left != null) {

            if(!findStart) {
                startPath.add(new Pair(root.val, "L"));
            }

            if(!findDest) {
                destPath.add(new Pair(root.val, "L"));
            }

            getShortestPath(root.left, startValue, destValue);

            if(!findStart) {
                startPath.remove(startPath.size() - 1);
            }

            if(!findDest) {
                destPath.remove(destPath.size() - 1);
            }
        }

        // Right
        if(root.right != null) {

            if(!findStart) {
                startPath.add(new Pair(root.val, "R"));
            }

            if(!findDest) {
                destPath.add(new Pair(root.val, "R"));
            }

            getShortestPath(root.right, startValue, destValue);

            if(!findStart) {
                startPath.remove(startPath.size() - 1);
            }

            if(!findDest) {
                destPath.remove(destPath.size() - 1);
            }
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        getShortestPath(root, startValue, destValue);

        StringBuilder ans = new StringBuilder();

        int n = Math.min(startPath.size(), destPath.size());

        int i = 0;

        // Find common path
        while(i < n) {

            Pair start = startPath.get(i);
            Pair dest = destPath.get(i);

            if(start.node != dest.node) {
                break;
            }

            i++;
        }

        // Go UP from start to LCA
        int a = startPath.size() - i;

        while(a > 0) {
            ans.append("U");
            a--;
        }

        // Go DOWN from LCA to destination
        for(int j = i-1; j < destPath.size()-1; j++) {
            ans.append(destPath.get(j).dir);
        }

        return ans.toString();
    }
}