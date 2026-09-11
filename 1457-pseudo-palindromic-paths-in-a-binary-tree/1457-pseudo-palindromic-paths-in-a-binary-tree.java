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
    Map<Integer,Integer> map = new HashMap<>();
    int count = 0;

    public void findAllPaths(TreeNode root) {
        if(root.left==null && root.right==null){
            int oneCount = 0;
            for(int keys : map.keySet()){
                if(map.get(keys)%2 != 0){
                    oneCount++;
                }
            }
            if(oneCount<2){
                count++;
            }

            return;
        }
        if(root.left != null){
            map.put(root.left.val, map.getOrDefault(root.left.val,0)+1);
            findAllPaths(root.left);
            map.put(root.left.val, map.get(root.left.val)-1);
        }
        if(root.right != null){
            map.put(root.right.val, map.getOrDefault(root.right.val,0)+1);
            findAllPaths(root.right);
            map.put(root.right.val, map.get(root.right.val)-1);
        }
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        map.put(root.val,1);
        findAllPaths(root);

        return count;
    }
}