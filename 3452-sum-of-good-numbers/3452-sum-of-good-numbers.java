class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            boolean good1 = true;
            boolean good2 = true;
            if(i+k < nums.length){
                if(nums[i] > nums[i+k]){
                    good1 = true;
                }
                else
                    good1 = false;
            }
            if(i-k >=0){
                if(nums[i] > nums[i-k]){
                    good2 = true;
                }
                else
                    good2 = false;
            }

            if(good1 == true && good2 == true)
                sum+=nums[i];
        }

        return sum;
    }
}