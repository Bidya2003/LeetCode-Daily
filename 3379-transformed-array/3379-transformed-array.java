class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                int next = (i + nums[i]) % nums.length;
                result[i] = nums[next];
            }
            else if(nums[i]<0){
                int next = (i + nums[i]) % nums.length;
                
                if(next < 0) {
                    next += nums.length;
                }
                
                result[i] = nums[next]; 
            }
            else{
                result[i] = 0;
            }
        }

        return result;
    }
}