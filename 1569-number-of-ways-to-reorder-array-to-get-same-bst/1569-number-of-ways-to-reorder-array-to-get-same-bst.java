class Solution {

    long MOD = 1000000007L;
    long[][] nCr;

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Pair {
        long ways;
        int size;

        Pair(long ways, int size) {
            this.ways = ways;
            this.size = size;
        }
    }

    public void makeTree(TreeNode node, int value) {

        if (node.val > value) {

            if (node.left == null) {
                node.left = new TreeNode(value);
                return;
            }

            makeTree(node.left, value);
        }
        else {

            if (node.right == null) {
                node.right = new TreeNode(value);
                return;
            }

            makeTree(node.right, value);
        }
    }


    public Pair countWays(TreeNode node) {

        // left subtree
        Pair left;

        if (node.left == null)
            left = new Pair(1, 0);
        else
            left = countWays(node.left);


        // right subtree
        Pair right;

        if (node.right == null)
            right = new Pair(1, 0);
        else
            right = countWays(node.right);


        // left + right elements কয়ভাবে interleave করা যাবে
        long mergeWays =
                nCr[left.size + right.size][left.size];


        // total ways
        long ways = mergeWays;

        ways = (ways * left.ways) % MOD;
        ways = (ways * right.ways) % MOD;


        // current node + left nodes + right nodes
        int size = 1 + left.size + right.size;


        return new Pair(ways, size);
    }


    public int numOfWays(int[] nums) {

        int n = nums.length;

        // -------------------------------
        // Combination table
        // -------------------------------

        nCr = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {

            nCr[i][0] = 1;
            nCr[i][i] = 1;

            for (int j = 1; j < i; j++) {

                nCr[i][j] =
                    (nCr[i-1][j-1] + nCr[i-1][j]) % MOD;
            }
        }


        // -------------------------------
        // BST বানানো
        // -------------------------------

        TreeNode root = new TreeNode(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            makeTree(root, nums[i]);
        }


        // ways বের করা
        Pair ans = countWays(root);


        // original ordering বাদ
        return (int)((ans.ways - 1 + MOD) % MOD);
    }
}