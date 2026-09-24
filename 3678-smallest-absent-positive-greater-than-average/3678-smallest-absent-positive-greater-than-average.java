class Solution {
    public int smallestAbsent(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        int avg = sum/nums.length;
        if(avg<0)
            avg = 1;
        else
            avg++;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(avg==nums[i])
                avg++;
            else if(avg<nums[i])
                return avg;
        }

        return avg;
    }
}