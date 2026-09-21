class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[i]==1 && nums[j]==2){
                    minDiff = Math.min(minDiff, Math.abs(i-j));
                }
            }
        }
        return (minDiff==Integer.MAX_VALUE) ? -1 : minDiff;
    }
}