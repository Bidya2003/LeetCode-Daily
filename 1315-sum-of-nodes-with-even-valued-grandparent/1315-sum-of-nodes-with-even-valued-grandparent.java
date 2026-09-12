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
    public int calculateSumEvenGrandparent(TreeNode root, int parent, int grandPa) {
        if(root == null){
            return 0;
        }
        int left = calculateSumEvenGrandparent(root.left, root.val, parent);
        int right = calculateSumEvenGrandparent(root.right, root.val, parent);

        int sum = left + right;
        if(grandPa % 2 == 0){
            sum += root.val;
        }

        return sum;
    }
    public int sumEvenGrandparent(TreeNode root) {
        return calculateSumEvenGrandparent(root,-1,-1);
    }
}