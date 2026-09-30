class Solution {
    public int minimumCost(int[] nums) {
        int sum = nums[0];
        int n = nums[0];

        Arrays.sort(nums);
        boolean added = false;
        int count = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == n && added == false){
                added = true;
                continue;
            }
            sum += nums[i];
            count++;
            if(count==3)
                break;
        }
        return sum;
    }
}