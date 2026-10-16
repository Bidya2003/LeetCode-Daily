/*
class Solution {
    public int sumCounts(int[] nums) {
        long res = 0;

        for(int i=0; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();

            for(int j=i; j<nums.length; j++){
                set.add(nums[j]);
                int n = set.size();
                res += (n * n);
            }
        }

        return (int)(res % 1000000007);
    }
}
*/

class Solution {

    long MOD = 1000000007L;

    long[] sum;
    long[] squareSum;
    long[] lazy;

    public void update(int node, int start, int end, int left, int right) {

        if(end < left || start > right)
            return;

        if(left <= start && end <= right) {

            long len = end - start + 1;

            squareSum[node] =
                (squareSum[node] + 2 * sum[node] + len) % MOD;

            sum[node] =
                (sum[node] + len) % MOD;

            lazy[node]++;

            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, left, right);
        update(node * 2 + 1, mid + 1, end, left, right);

        sum[node] =
            (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        squareSum[node] =
            (squareSum[node * 2] + squareSum[node * 2 + 1]) % MOD;
    }

    public void push(int node, int start, int end) {

        if(lazy[node] == 0 || start == end)
            return;

        int mid = start + (end - start) / 2;

        apply(node * 2, start, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }

    public void apply(int node, int start, int end, long val) {

        long len = end - start + 1;

        // (d + val)^2
        // = d^2 + 2*val*d + val^2

        squareSum[node] =
            (squareSum[node]
            + 2 * val * sum[node]
            + val * val % MOD * len) % MOD;

        sum[node] =
            (sum[node] + val * len) % MOD;

        lazy[node] += val;
    }

    public int sumCounts(int[] nums) {

        int n = nums.length;

        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();

        long res = 0;

        for(int j = 0; j < n; j++) {

            int prev = last.getOrDefault(nums[j], -1);

            // starts prev+1 ... j get +1 distinct count
            update(
                1,
                0,
                n - 1,
                prev + 1,
                j
            );

            last.put(nums[j], j);

            // all subarrays ending at j
            res = (res + squareSum[1]) % MOD;
        }

        return (int) res;
    }
}