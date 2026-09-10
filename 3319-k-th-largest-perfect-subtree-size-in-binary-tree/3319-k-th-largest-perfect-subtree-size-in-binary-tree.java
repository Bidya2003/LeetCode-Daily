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
    public int findAllPerfectSubtree(TreeNode root, List<Integer> subtreeSize) {
        if(root==null){
            return 0;
        }

        int left = findAllPerfectSubtree(root.left,subtreeSize);
        int right = findAllPerfectSubtree(root.right,subtreeSize);

        if(left==-1 || right==-1)
            return -1;

        int total = -1;
        if(left == right){
            total = left + right + 1;
            subtreeSize.add(total);
        }

        return total;
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> subtreeSize = new ArrayList<>();

        findAllPerfectSubtree(root,subtreeSize);
        System.out.println(subtreeSize);

        Collections.sort(subtreeSize, (a,b) -> Integer.compare(b,a));

    

        return (subtreeSize.size()<k) ? -1 : subtreeSize.get(k-1);
    }
}