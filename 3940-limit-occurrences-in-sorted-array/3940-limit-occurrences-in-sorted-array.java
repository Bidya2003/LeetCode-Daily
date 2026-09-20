class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int prev = 1;
        int next = 1;

        int count = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1])
                count++;
            else
                count = 1;

            if(count>k){
                next++;
            }
            else{
                nums[prev] = nums[next];
                next++;
                prev++;
            }
        }

        return Arrays.copyOfRange(nums,0,prev);
    }
}