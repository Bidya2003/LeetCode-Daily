class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        long val = 0;

        while(left <= right){
            if(left == right){
                val += nums[left];
                left++;
                right--;
                continue;
            }
            String first = Integer.toString(nums[left]);
            String sec = Integer.toString(nums[right]);

            String concat = first + sec;

            val += Long.parseLong(concat);

            left++;
            right--;
        }

        return val;
    }
}