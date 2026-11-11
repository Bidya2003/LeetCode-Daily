
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long ans = 0;

        // Option 1: Buy both requirements separately
        long x = (long) need1 * cost1 + (long) need2 * cost2;

        // Option 2: Buy common items first
        int k = Math.min(need1, need2);

        long y = (long) k * costBoth
               + (long) (need1 - k) * cost1
               + (long) (need2 - k) * cost2;

        // Option 3: Buy only both items
        long z = (long) Math.max(need1, need2) * costBoth;

        ans = Math.min(x, Math.min(y, z));

        return ans;
    }
}
