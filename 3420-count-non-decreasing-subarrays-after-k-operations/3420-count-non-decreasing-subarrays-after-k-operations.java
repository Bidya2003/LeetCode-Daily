/*

//BRUTE FORCE (TIME LIMIT EXCEEDED (727/731 PASSED))

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long ans = nums.length;

        for(int idx = 0; idx < nums.length; idx++) {
            int curr = nums[idx];
            long ope = 0;

            for(int i = idx + 1; i < nums.length; i++) {
                if(nums[i] < curr) {
                    ope += (long) curr - nums[i];
                }
                else {
                    curr = nums[i];
                }

                if(ope > k)
                    break;
                else
                    ans++;
            }
        }

        return ans;
    }
}
*/


//CHATGPT
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long ans = 0;
        long cost = 0;
        int j = n - 1;

        for(int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Merge all smaller groups
            while(!dq.isEmpty() && dq.peekLast()[0] < num) {
                int[] last = dq.removeLast();

                count += last[1];

                cost += (long)(num - last[0]) * last[1];
            }

            dq.offerLast(new int[]{num, count});

            // Shrink window if cost exceeds k
            while(cost > k) {
                int[] first = dq.removeFirst();

                int rightmostNum = first[0];
                int rightmostCount = first[1];

                cost -= (long)(rightmostNum - nums[j]);
                j--;

                if(rightmostCount > 1) {
                    dq.offerFirst(new int[]{rightmostNum, rightmostCount - 1});
                }
            }

            // Count all valid subarrays ending at j
            ans += j - i + 1;
        }

        return ans;
    }
}

