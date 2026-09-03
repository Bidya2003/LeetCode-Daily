/*
class Solution {
    public boolean checkAllSubarraySum(int[] nums, int k, int start, int end, int total) {
        if(total==0 || total%k == 0)
            return true;
        if(end==nums.length)
            return false;

        return checkAllSubarraySum(nums,k,start,end+1,total+nums[end]) || checkAllSubarraySum(nums,k,start+1,end+1,total+nums[end]-nums[start]);
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2)
            return false;

        int total = nums[0] + nums[1];
        return checkAllSubarraySum(nums,k,0,2,total);
    }
}
*/





/*
prefixSum[i] % k == prefixSum[j] % k

                ↓

(prefixSum[i] - prefixSum[j]) % k == 0

                ↓

মাঝের subarray-এর sum k দিয়ে divisible

*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        if(nums.length < 2)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        // remainder 0 যেন index -1 থেকে এসেছে ধরা হয়
        map.put(0, -1);

        int total = 0;

        for(int i = 0; i < nums.length; i++) {

            total += nums[i];

            int rem = total % k;

            if(map.containsKey(rem)) {

                // অন্তত 2টা element থাকতে হবে
                if(i - map.get(rem) >= 2)
                    return true;
            }
            else {
                // প্রথম index-টাই রাখতে হবে
                map.put(rem, i);
            }
        }

        return false;
    }
}