class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumSingleDig = 0;
        int sumDoubleDig = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 9){
                sumSingleDig += nums[i];
            }
            else{
                sumDoubleDig += nums[i];
            }
        }

        if(sumSingleDig == sumDoubleDig)
            return false;

        return true;
    }
}