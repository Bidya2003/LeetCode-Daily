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
        int maxValue;
        int dominantCount;
        Pair(int maxValue, int dominantCount){
            this.maxValue = maxValue;
            this.dominantCount = dominantCount;
        }
    }
    public Pair findAllDominantNodes(TreeNode root) {
        if(root==null){
            return new Pair(0,0);
        }

        Pair left = findAllDominantNodes(root.left);
        Pair right = findAllDominantNodes(root.right);

        int max = Math.max(left.maxValue, right.maxValue);
        int dominantCount = left.dominantCount + right.dominantCount;
        if(root.val >= max){
            max = root.val;
            dominantCount++;
        }

        return new Pair(max,dominantCount);
    }
    public int countDominantNodes(TreeNode root) {
        Pair ans = findAllDominantNodes(root);

        return ans.dominantCount;
    }
}