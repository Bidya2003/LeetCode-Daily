class Solution {
    public int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }

    public int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0; // যেকোনো একটি সংখ্যা ০ হলে লসাগু ০ হয়
        }
        // ওভারফ্লো এড়াতে প্রথমে ভাগ করে তারপর গুণ করা ভালো
        return Math.abs((a / gcd(a, b)) * b);
    }

    public int checkAllLength(int[] nums, int idx) {
        int prod = nums[idx];
        int gcd = nums[idx];
        int lcm = nums[idx];

        int ans = -1;

        idx++;
        int count = 1;
        while(idx < nums.length){
            prod = prod * nums[idx];
            gcd = gcd(gcd,nums[idx]);
            lcm = lcm(lcm,nums[idx]);
            count++;

            if(prod == gcd * lcm){
                ans = count;
            }
            idx++;
        }
        return ans;
    }

    public int maxLength(int[] nums) {
        int result = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int ans = checkAllLength(nums,i);
            result = Math.max(result,ans);
        }

        return result;
    }
}