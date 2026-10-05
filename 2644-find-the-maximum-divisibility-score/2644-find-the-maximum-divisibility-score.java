class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxDiv = 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<divisors.length; i++){
            int total = 0;

            for(int j=0; j<nums.length; j++){
                if(nums[j] % divisors[i] == 0){
                    total++;
                }
            }

            if(maxDiv < total){
                maxDiv = total;
                ans = divisors[i];
            }
            else if(maxDiv == total){
                ans = Math.min(ans, divisors[i]);
            }
        }

        return ans;
    }
}