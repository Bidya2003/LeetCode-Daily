class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int n = nums[i];

            int mul = 1;
            int large = 0;

            while(n != 0){
                large = Math.max(large, n%10);
                n = n/10;
                mul *= 10;
            }

            while(mul >= 1){
                mul = mul/10;
                n = n + mul*large;
            }

            nums[i] = n;
        }

        int sum = 0;
        for(int i : nums){
            sum +=i;
        }

        return sum;
    }
}