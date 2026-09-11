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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,int[]> treenodes = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        for(int[] arr : descriptions){
            if(treenodes.containsKey(arr[0])){
                treenodes.get(arr[0])[arr[2]] = arr[1];
            }
            else{
                treenodes.put(arr[0],new int[2]);
                Arrays.fill(treenodes.get(arr[0]), -1);
                treenodes.get(arr[0])[arr[2]] = arr[1];
            }

            indegree.put(arr[0], indegree.getOrDefault(arr[0],0));
        }

        for(int[] arr : descriptions){
            if(indegree.containsKey(arr[1])){
                indegree.put(arr[1], indegree.get(arr[1])+1);
            }
        }

        TreeNode root = null;

        for(int keys : indegree.keySet()){
            if(indegree.get(keys)==0){
                root = new TreeNode(keys);
                break;
            }
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode front = q.remove();

            if(treenodes.containsKey(front.val)){
                int left = treenodes.get(front.val)[1];
                int right = treenodes.get(front.val)[0];

                if(left != -1){
                    front.left = new TreeNode(left);
                    q.add(front.left);
                }
                if(right != -1){
                    front.right = new TreeNode(right);
                    q.add(front.right);
                }
            }
        }

        return root;
    }
}