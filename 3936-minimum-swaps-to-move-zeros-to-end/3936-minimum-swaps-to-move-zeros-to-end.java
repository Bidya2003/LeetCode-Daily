class Solution {
    public int minimumSwaps(int[] nums) {
        int count = 0;

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            if(nums[right] == 0)
                right--;
            else if(nums[left] != 0)
                left++;
            else if(nums[right] != 0 && nums[left] == 0){
                count++;
                left++;
                right--;
            }
        }

        return count;
    }
}