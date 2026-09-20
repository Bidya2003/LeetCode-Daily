class Solution {
    public int gcd(int divisor, int divident){
        if(divident == 0){
            return divisor;
        }

        int rev = divisor % divident;
        return gcd(divident,rev);
    }

    public long maxPairStrength(int[] nums) {
        long max = -1;

        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                int gcd = gcd(nums[i],nums[j]);

                long temp = (((long)nums[i] * nums[j]) / ((long)gcd * gcd));

                max = Math.max(max,temp);
            }
        }

        return max;
    }
}