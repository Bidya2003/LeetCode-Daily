class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxVal = 0;

        for(int i=0; i<nums.length; i++){
            for(int j= i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    long val = (long)(nums[i] - nums[j]) * (long)nums[k];
                    maxVal = Math.max(maxVal,val);
                }
            }
        }

        return maxVal;
    }
}