class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int maxXor = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) > Math.min(nums[i], nums[j])){
                    break;
                }

                int xor = nums[i] ^ nums[j];

                maxXor = Math.max(maxXor,xor);
            }
        }

        return maxXor;
    }
}