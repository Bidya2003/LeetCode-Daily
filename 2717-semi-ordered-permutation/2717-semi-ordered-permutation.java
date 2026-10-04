class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int firstIdx = nums.length;
        int lastIdx = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                firstIdx = Math.min(firstIdx, i);
            }
            else if(nums[i] == nums.length){
                lastIdx = Math.max(lastIdx, i);
            }
        }

        int count = firstIdx + (nums.length-1-lastIdx);

        if(firstIdx > lastIdx)
            count --;

        return count;

    }
}