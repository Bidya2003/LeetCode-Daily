class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int midEle = nums[nums.length/2];

        for(int i=0;i<nums.length;i++){
            if(i != nums.length/2 && nums[i]==midEle){
                return false;
            }
        }

        return true;
    }
}