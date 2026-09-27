class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for(int i : nums){
            total += i;
        }

        int ans = 0;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                if(sum == (total - sum))
                    ans+=2;
                else if(Math.abs(sum - (total - sum)) == 1){
                    ans++;
                }
            }
            else{
                sum += nums[i];
            }
        }

        return ans;
    }
}