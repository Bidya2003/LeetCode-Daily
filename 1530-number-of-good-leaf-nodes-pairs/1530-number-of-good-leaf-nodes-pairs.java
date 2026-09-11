class Solution {

    List<List<TreeNode>> paths = new ArrayList<>();

    public void getAllPaths(TreeNode root, List<TreeNode> track) {

        if(root == null) return;

        if(root.left == null && root.right == null) {
            paths.add(new ArrayList<>(track));
            return;
        }

        if(root.left != null) {
            track.add(root.left);
            getAllPaths(root.left, track);
            track.remove(track.size() - 1);
        }

        if(root.right != null) {
            track.add(root.right);
            getAllPaths(root.right, track);
            track.remove(track.size() - 1);
        }
    }

    public int countPairs(TreeNode root, int distance) {

        paths.clear();

        List<TreeNode> track = new ArrayList<>();
        track.add(root);

        getAllPaths(root, track);

        int count = 0;

        for(int i = 0; i < paths.size(); i++) {

            for(int j = i + 1; j < paths.size(); j++) {

                int size = Math.min(
                    paths.get(i).size(),
                    paths.get(j).size()
                );

                int k = 0;

                while(k < size &&
                      paths.get(i).get(k) == paths.get(j).get(k)) {
                    k++;
                }

                int first = paths.get(i).size() - k;
                int second = paths.get(j).size() - k;

                int pathDiff = first + second;

                if(pathDiff <= distance) {
                    count++;
                }
            }
        }

        return count;
    }
}