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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Set<TreeNode> infected = new HashSet<>();

        Queue<TreeNode> makingGraph = new LinkedList<>();
        Queue<TreeNode> trackInfected = new LinkedList<>();
        TreeNode findStart = null;
        
        makingGraph.add(root);

        while(!makingGraph.isEmpty()){
            TreeNode front = makingGraph.remove();
            if(front.val == start){
                findStart = front;
                // trackInfected.add(front);
                // infected.add(front);
            }

            if(front.left != null){
                parents.put(front.left,front);
                makingGraph.add(front.left);
            }
            if(front.right != null){
                parents.put(front.right,front);
                makingGraph.add(front.right);
            }
        }

        makingGraph.add(findStart);
        infected.add(findStart);

        int time = 0;
        while(!makingGraph.isEmpty()){
            int size = makingGraph.size();

            for(int i=0;i<size;i++){
                TreeNode front = makingGraph.remove();

                if(parents.containsKey(front)){
                    TreeNode parent = parents.get(front);
                    if(!infected.contains(parent)){
                        makingGraph.add(parent);
                        infected.add(parent);
                    }
                }

                if(front.left != null && !infected.contains(front.left)){
                    makingGraph.add(front.left);
                    infected.add(front.left);
                }
                if(front.right != null && !infected.contains(front.right)){
                    makingGraph.add(front.right);
                    infected.add(front.right);
                }
            }

            time++;
        }
        return time-1;
    }
}