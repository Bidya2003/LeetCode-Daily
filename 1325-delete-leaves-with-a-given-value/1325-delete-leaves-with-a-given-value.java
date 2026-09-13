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
    public TreeNode removeLeafNodesGivenValue(TreeNode root, TreeNode parent, char c, int target) {
        if(root==null)
            return null;

        root.left = removeLeafNodesGivenValue(root.left,root,'L',target);
        root.right =  removeLeafNodesGivenValue(root.right,root,'R',target);

        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        return removeLeafNodesGivenValue(root,null,'X',target);

        
    }
}