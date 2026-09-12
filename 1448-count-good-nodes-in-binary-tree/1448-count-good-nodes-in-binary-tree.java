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
    int count = 0;
    public void findGoodNodes(TreeNode root, int maxValue) {
        if(root == null){
            return;
        }
        if(root.val>=maxValue){
            maxValue = root.val;
            count++;
        }
        findGoodNodes(root.left, maxValue);
        findGoodNodes(root.right, maxValue);
    }
    public int goodNodes(TreeNode root) {
        findGoodNodes(root,Integer.MIN_VALUE);
        return count;
    }
}