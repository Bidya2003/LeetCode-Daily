class Solution {
    public int alternatingSubarray(int[] nums) {
        int longest = -1;

        for(int i=1;i<nums.length; i++){
            boolean first = false;
            boolean sec = true;
            int count = 1;

            for(int j=i; j<nums.length; j++){
                if(sec == true){
                    if(nums[j] - nums[j-1] == 1){
                        count++;
                        longest = Math.max(longest,count);
                        sec = false;
                        first = true;
                    }
                    else
                        break;
                }
                else{
                    if(nums[j] - nums[j-1] == -1){
                        count++;
                        longest = Math.max(longest,count);
                        sec = true;
                        first = false;
                    }
                    else
                        break;
                }
            }
        }

        return longest;
    }
}