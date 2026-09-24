class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int sumDigits = 0;
            int n = nums[i];
            while(n!=0){
                sumDigits += (n%10);
                n = n/10;
            }

            if(i == sumDigits)
                return i;
        }

        return -1;
    }
}