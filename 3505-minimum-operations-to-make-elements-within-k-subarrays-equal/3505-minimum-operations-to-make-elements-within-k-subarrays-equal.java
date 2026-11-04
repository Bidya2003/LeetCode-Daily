// class Solution {
//     class Pair{
//         int start;
//         int end;
//         long ope;
//         Pair(int start, int end, long ope){
//             this.start = start;
//             this.end = end;
//             this.ope = ope;
//         }
//     }

//     long ans;

//     public void findMinOpe(List<Pair> operations, int next, long total, int k){
//         if(k == 0){
//             ans = Math.min(ans, total);
//             return;
//         }
//         for(int i=0; i<operations.size(); i++){
//             int start = operations.get(i).start;
//             int end = operations.get(i).end;
//             long ope = operations.get(i).ope;

//             if(start <= next)
//                 continue;
            
//             findMinOpe(operations, end, total+ope, k-1);
//         }
//     }

//     public long minOperations(int[] nums, int x, int k) {
//         List<Pair> operations = new ArrayList<>();

//         for(int i=0; i<=nums.length-x; i++){
//             int[] curr = Arrays.copyOfRange(nums,i,i+x);

//             Arrays.sort(curr);

//             int mid = curr[x/2];

//             long ope = 0;

//             for(int n : curr){
//                 ope += Math.abs((long)n - mid);
//             }

//             operations.add(new Pair(i, i+x-1, ope));
//         }

//         //Collections.sort(operations, (a,b) -> Integer.compare(a.ope, b,ope));

//         ans = Long.MAX_VALUE;

//         findMinOpe(operations, -1, 0, k);

//         return ans;
//     }
// }




class Solution {
    class Pair {
        int start, end;
        long ope;

        Pair(int start, int end, long ope) {
            this.start = start;
            this.end = end;
            this.ope = ope;
        }
    }

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    int leftSize = 0, rightSize = 0;
    long leftSum = 0, rightSum = 0;

    void addMap(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void removeMap(TreeMap<Integer, Integer> map, int val) {
        int c = map.get(val);
        if (c == 1) map.remove(val);
        else map.put(val, c - 1);
    }

    void balance() {
        while (leftSize > rightSize + 1) {
            int val = left.lastKey();
            removeMap(left, val);
            leftSize--;
            leftSum -= val;

            addMap(right, val);
            rightSize++;
            rightSum += val;
        }

        while (leftSize < rightSize) {
            int val = right.firstKey();
            removeMap(right, val);
            rightSize--;
            rightSum -= val;

            addMap(left, val);
            leftSize++;
            leftSum += val;
        }
    }

    void add(int val) {
        if (left.isEmpty() || val <= left.lastKey()) {
            addMap(left, val);
            leftSize++;
            leftSum += val;
        } else {
            addMap(right, val);
            rightSize++;
            rightSum += val;
        }
        balance();
    }

    void remove(int val) {
        if (left.containsKey(val)) {
            removeMap(left, val);
            leftSize--;
            leftSum -= val;
        } else {
            removeMap(right, val);
            rightSize--;
            rightSum -= val;
        }
        balance();
    }

    long getCost() {
        long mid = left.lastKey();
        return mid * leftSize - leftSum
             + rightSum - mid * rightSize;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        List<Pair> operations = new ArrayList<>();

        left.clear();
        right.clear();
        leftSize = rightSize = 0;
        leftSum = rightSum = 0;

        for (int i = 0; i < x; i++) add(nums[i]);

        operations.add(new Pair(0, x - 1, getCost()));

        for (int i = x; i < n; i++) {
            remove(nums[i - x]);
            add(nums[i]);

            operations.add(
                new Pair(i - x + 1, i, getCost())
            );
        }

        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++)
            Arrays.fill(dp[i], INF);

        Arrays.fill(dp[0], 0);

        for (int t = 1; t <= k; t++) {
            for (int i = x; i <= n; i++) {
                dp[t][i] = dp[t][i - 1];

                dp[t][i] = Math.min(
                    dp[t][i],
                    dp[t - 1][i - x] + operations.get(i - x).ope
                );
            }
        }

        return dp[k][n];
    }
}
