class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean even = false;
        boolean odd = false;

        if(nums[0] % 2 == 0)
            even = true;
        else
            odd = true;

        for(int i=1; i<nums.length; i++){
            if(even == true){
                if(nums[i] % 2 != 0){
                    even = false;
                    odd = true;
                }
                else
                    return false;
            }

            else{
                if(nums[i] % 2 == 0){
                    odd = false;
                    even = true;
                }
                else
                    return false;
            }
        }

        return true;
    }
}