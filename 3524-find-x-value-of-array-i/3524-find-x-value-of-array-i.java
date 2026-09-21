// class Solution {
//     public long[] resultArray(int[] nums, int k) {
//         long[] dp = new long[nums.length];
        
//         //Arrays.fill(dp,-1);

//         long[] ans = new long[k];
//         int x = k-1;
//         while(x>=0){
//             int count = 0;

//             for(int i=0; i<nums.length; i++){
//                 for(int j=i+1; j<=nums.length; j++){
//                     if(j==i+1) 
//                         dp[j-1] = nums[i] % k;
//                     else
//                         dp[j-1] = (dp[j-2] * nums[j-1]) % k;

//                     if(dp[j-1]!=-1 && dp[j-1] % k == x)
//                         count++;
//                 }
//             }

//             // for(int j=0; j<nums.length; j++){
//             //     for(int i=0;i<nums.length;i++){
//             //         System.out.print(dp[j][i] + " ");
//             //         if(dp[j][i]!=-1 && dp[j][i] % k == x)
//             //             count++;
//             //     }
//             //     System.out.println();
//             // }

//             ans[x] = count;
//             x--;
//         }

//         return ans;
//     }
// }



class Solution { 
    public long[] resultArray(int[] nums, int k) { 
        
        long[] dp = new long[k];
        long[] next = new long[k];
        long[] ans = new long[k];

        for(int i = 0; i < nums.length; i++) {

            Arrays.fill(next, 0);

            // Only current element
            int rem = nums[i] % k;
            next[rem]++;

            // Previous subarrays + current element
            for(int j = 0; j < k; j++) {
                int newRem = (j * rem) % k;
                next[newRem] += dp[j];
            }

            // Count all subarrays ending at i
            for(int j = 0; j < k; j++) {
                ans[j] += next[j];
            }

            // next -> dp
            long[] temp = dp;
            dp = next;
            next = temp;
        }

        return ans;
    }
}