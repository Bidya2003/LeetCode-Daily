
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        int ans = 0;

        Arrays.sort(nums);

        int i = 0;
        int j = (n + 1) / 2;

        while(i < n/2 && j < n) {
            if(2L * nums[i] <= nums[j]) {
                ans += 2;
                i++;
                j++;
            }
            else {
                j++;
            }
        }

        return ans;
    }
}
