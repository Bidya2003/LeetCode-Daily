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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        int minSwap = 0;

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            int[][] nums = new int[size][2];
            for(int i=0;i<size;i++){
                TreeNode front = q.remove();

                if(front.left != null)
                    q.add(front.left);
                if(front.right != null)
                    q.add(front.right);

                nums[i][0] = front.val;
                nums[i][1] = i;
            }

            Arrays.sort(nums, (a,b)->Integer.compare(a[0],b[0]));

            boolean[] visited = new boolean[size];

            for(int i=0;i<size;i++){
                if(visited[i]==true || nums[i][1]==i){
                    continue;
                }

                int cycleLength = 0;
                int cycle = i;

                while(!visited[cycle]){
                    visited[cycle] = true;

                    cycle = nums[cycle][1];

                    cycleLength++;
                }

                minSwap += (cycleLength-1);
            }
        }

        return minSwap;
    }
}