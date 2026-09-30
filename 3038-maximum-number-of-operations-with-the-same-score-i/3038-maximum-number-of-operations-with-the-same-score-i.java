class Solution {
    public int maxOperations(int[] nums) {
        int score = -1;
        int count = 0;

        int n = (nums.length % 2 == 0) ? nums.length : nums.length-1;

        for(int i=0; i<n; i+=2){
            if(score == -1){
                score = nums[i] + nums[i+1];
                count++;
            }
            else if(score == nums[i] + nums[i+1]){
                count++;
            }
            else{
                break;
            }
        }

        return count;
    }
}