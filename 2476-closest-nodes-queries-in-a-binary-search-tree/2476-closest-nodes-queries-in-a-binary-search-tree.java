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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nodeValues = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode front = q.remove();
            nodeValues.add(front.val);

            if(front.left != null){
                q.add(front.left);
            }

            if(front.right != null){
                q.add(front.right);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        Collections.sort(nodeValues);

        for(int i=0;i<queries.size();i++){
            ans.add(new ArrayList<>());

            int largest = -1;
            int right = 0; int left = nodeValues.size()-1;
            int mid;
            while(right<=left){
                mid = right + (left-right)/2;
                if(nodeValues.get(mid) > queries.get(i)){
                    left = mid-1;
                }
                else{
                    largest = nodeValues.get(mid);
                    right = mid+1;
                }
            }
            // for(int large=nodeValues.size()-1; large>=0; large--){
            //     if(nodeValues.get(large) <= queries.get(i)){
            //         largest = nodeValues.get(large);
            //         break;
            //     }
            // }
            ans.get(i).add(largest);


            int smallest = -1;
            left = 0; right = nodeValues.size()-1;

            while(left<=right){
                mid = left + (right-left)/2;
                if(nodeValues.get(mid) < queries.get(i)){
                    left = mid+1;
                }
                else{
                    smallest = nodeValues.get(mid);
                    right = mid-1;
                }
            }

            // for(int small=0;small<nodeValues.size();small++){
            //     if(nodeValues.get(small) >= queries.get(i)){
            //         smallest = nodeValues.get(small);
            //         break;
            //     }
            // }
            ans.get(i).add(smallest);
        }

        return ans;
    }
}