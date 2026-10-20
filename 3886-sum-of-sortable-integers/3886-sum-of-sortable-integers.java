class Solution {

    // এই block-টা rotate করে target-এর corresponding block
    // বানানো সম্ভব কি না
    public boolean checkSubArray(int[] nums, int[] target, int start, int end) {

        int drop = 0;

        // যদি কোনো drop না থাকে,
        // তাহলে original start থেকেই compare করব
        int rotationStart = start;

        for (int i = start; i < end; i++) {

            if (nums[i] > nums[i + 1]) {

                drop++;

                // একটার বেশি drop => কোনো rotation sorted করতে পারবে না
                if (drop > 1)
                    return false;

                // drop-এর পর থেকেই sorted sequence শুরু হবে
                rotationStart = i + 1;
            }
        }

        int len = end - start + 1;

        // rotationStart থেকে circularly target-এর সাথে compare
        for (int i = 0; i < len; i++) {

            int idx =
                start + ((rotationStart - start + i) % len);

            if (nums[idx] != target[start + i])
                return false;
        }

        return true;
    }


    public int sortableIntegers(int[] nums) {

        int n = nums.length;

        int[] target = nums.clone();
        Arrays.sort(target);

        int ans = 0;


        // divisor বের করছি
        for (int k = 1; k <= n; k++) {

            if (n % k != 0)
                continue;

            boolean possible = true;


            // IMPORTANT: consecutive non-overlapping blocks
            for (int start = 0; start < n; start += k) {

                int end = start + k - 1;

                if (!checkSubArray(nums, target, start, end)) {
                    possible = false;
                    break;
                }
            }


            // সব block valid হলে k sortable
            if (possible) {
                ans += k;
            }
        }

        return ans;
    }
}