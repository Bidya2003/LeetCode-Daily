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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){
            if(level%2==0){
                int size = q.size();
                List<Integer> temp = new ArrayList<>();
                List<TreeNode> parents = new ArrayList<>();

                for(int i=0; i<size; i++){
                    TreeNode front = q.remove();
                    parents.add(front);

                    if(front.left != null){
                        q.add(front.left);
                        temp.add(front.left.val);
                    }
                    if(front.right != null){
                        q.add(front.right);
                        temp.add(front.right.val);
                    }
                }
                Collections.reverse(temp);

                int next = 0;
                for(TreeNode front : parents){
                    if(front.left != null){
                        front.left.val = temp.get(next);
                        next++;
                    }
                    if(front.right != null){
                        front.right.val = temp.get(next);
                        next++;
                    }
                }
            }
            else{
                int size = q.size();

                for(int i=0; i<size; i++){
                    TreeNode front = q.remove();

                    if(front.left != null){
                        q.add(front.left);
                    }
                    if(front.right != null){
                        q.add(front.right);
                    }
                }
            }
            level++;
        }

        return root;
    }
}