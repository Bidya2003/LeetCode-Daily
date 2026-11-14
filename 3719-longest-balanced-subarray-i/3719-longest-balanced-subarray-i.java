/*
//TIME LIMIT EXCEEDED (998 / 1001 testcases passed)

class Solution {
    public int longestBalanced(int[] nums) {
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<nums.length-1; i++){
            List<Integer> even = new ArrayList<>();
            List<Integer> odd = new ArrayList<>();

            for(int j=i; j<nums.length; j++){
                if(nums[j] % 2 == 0 && !even.contains(nums[j])){
                    even.add(nums[j]);
                }
                else if(nums[j] % 2 != 0 && !odd.contains(nums[j])){
                    odd.add(nums[j]);
                }

                if(odd.size() == even.size()){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }

        return (ans == Integer.MIN_VALUE)? 0 : ans;
    }
}
*/


class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;

        int[] seen = new int[100001];

        for(int i=0; i<nums.length; i++){
            int odd = 0;
            int even = 0;

            for(int j=i; j<nums.length; j++){
                if(seen[nums[j]] != i+1){
                    seen[nums[j]] = i+1;

                    if(nums[j] % 2 != 0){
                        odd++;
                    }
                    else{
                        even++;
                    }
                }

                if(odd == even){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }

        return ans;
    }
}