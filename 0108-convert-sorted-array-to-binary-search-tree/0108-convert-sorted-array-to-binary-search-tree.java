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
    public TreeNode makeBST(int[] nums, int start, int end, TreeNode root) {
        if(start > end){
            return null;
        }
        int main = start + (end-start)/2;
        root = new TreeNode(nums[main]);

        root.left = makeBST(nums,start,main-1,root.left);
        root.right = makeBST(nums,main+1,end,root.left);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        return makeBST(nums,0,nums.length-1,root);
    }
}