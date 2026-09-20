class Solution {
    public int[] countOppositeParity(int[] nums) {
        int[] ans = new int[nums.length];
        int countOdd = 0;
        int countEven = 0;

        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] % 2 ==0){
                ans[i] = countOdd;
                countEven++;
            }
            else{
                ans[i] = countEven;
                countOdd++;
            }
        }
        return ans;
    }
}