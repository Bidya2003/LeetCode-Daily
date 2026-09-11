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
    public boolean evaluateEntireTree(TreeNode root) {
        if(root.left==null && root.right==null)
            return (root.val==1);
        
        boolean left = evaluateEntireTree(root.left);
        boolean right = evaluateEntireTree(root.right);

        boolean ans = false;
        if(root.val == 2){
            ans = (left || right);
        }
        else{
            ans = (left && right);
        }

        return ans;
    }
    public boolean evaluateTree(TreeNode root) {
        return evaluateEntireTree(root);
    }
}