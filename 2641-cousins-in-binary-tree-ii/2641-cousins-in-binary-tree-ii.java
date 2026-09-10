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
    public void replaceAllValueInTree(TreeNode root, List<Integer> sumAtEveryLevel, int level){
        if(root.left==null && root.right==null)
            return;
        
        if(root.left!= null) replaceAllValueInTree(root.left,sumAtEveryLevel,level+1);
        if(root.right!= null) replaceAllValueInTree(root.right,sumAtEveryLevel,level+1);

        int sum = 0;
        if(root.left!= null){
            sum+=root.left.val;
        }
        if(root.right!= null){
            sum+=root.right.val;
        }

        System.out.println("sum - " + sum + " level - " + level + " get - " + sumAtEveryLevel.get(level));

        int replace = sumAtEveryLevel.get(level+1) - sum;

        if(root.left!= null){
            root.left.val = replace;
        }
        if(root.right!= null){
            root.right.val = replace;
        }
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> sumAtEveryLevel = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            int total = 0;
            for(int i=0;i<size;i++){
                TreeNode front = q.remove();
                total += front.val;

                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }

            sumAtEveryLevel.add(total);
        }

        System.out.println(sumAtEveryLevel);

        replaceAllValueInTree(root,sumAtEveryLevel,0);
        root.val = 0;

        return root;
    }
}