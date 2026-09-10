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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sumAtEveryLevel = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            long total = 0;
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

        Collections.sort(sumAtEveryLevel, (a,b)->Long.compare(b,a));

        return (sumAtEveryLevel.size() < k) ? -1 : sumAtEveryLevel.get(k-1);
    }
}