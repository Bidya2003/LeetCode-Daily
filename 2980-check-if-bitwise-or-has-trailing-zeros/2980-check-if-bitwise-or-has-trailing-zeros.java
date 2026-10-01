class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int or = nums[i];
                for(int k=j; k<nums.length; k++){
                    or = or | nums[k];

                    if(or % 2 == 0)
                        return true;
                }
            }
        }

        return false;
    }
}