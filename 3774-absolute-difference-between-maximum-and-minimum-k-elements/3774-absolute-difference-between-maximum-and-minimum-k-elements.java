class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int largest = 0;
        int smallest = 0;

        for(int i=0; i<nums.length; i++){
            largest += nums[nums.length-1-i];
            smallest += nums[i];
            k--;
            if(k==0)
                break;
        }

        return Math.abs(largest - smallest);
    }
}