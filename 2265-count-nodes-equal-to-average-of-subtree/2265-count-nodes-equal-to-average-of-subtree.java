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
    class Pair{
        int sum;
        int countEqualNodes;
        int countTotalNodes;

        Pair(int sum, int countEqualNodes, int countTotalNodes){
            this.sum = sum;
            this.countEqualNodes = countEqualNodes;
            this.countTotalNodes = countTotalNodes;
        }
    }
    public Pair averageOfSubtreeCount(TreeNode root) {
        if(root==null){
            return new Pair(0,0,0);
        }

        Pair left = averageOfSubtreeCount(root.left);
        Pair right = averageOfSubtreeCount(root.right);

        int sum = left.sum + right.sum + root.val;
        int countTotalNodes = left.countTotalNodes + right.countTotalNodes + 1;
        int countEqualNodes = left.countEqualNodes + right.countEqualNodes;
        
        if(sum/countTotalNodes == root.val){
            countEqualNodes++;
        }

        return new Pair(sum,countEqualNodes,countTotalNodes);
    }
    public int averageOfSubtree(TreeNode root) {
        int count = 0;

        Pair ans = averageOfSubtreeCount(root);

        return ans.countEqualNodes;
    }
}