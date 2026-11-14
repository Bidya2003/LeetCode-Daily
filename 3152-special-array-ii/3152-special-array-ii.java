/*
//Time Limit Exceeded (523 / 536 testcases passed)

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        List<Integer> notSpecial = new ArrayList<>();

        for(int i=0; i<nums.length-1; i++){
            if( (nums[i]%2 == 0 && nums[i+1]%2 ==0)||
                (nums[i]%2 != 0 && nums[i+1]%2 !=0) )
            {
                notSpecial.add(i);
            }
        }

        Collections.sort(notSpecial);

        boolean[] ans = new boolean[queries.length];
        Arrays.fill(ans,true);

        for(int i=0; i<queries.length; i++){
            for(int j=0; j<notSpecial.size(); j++){
                if(notSpecial.get(j) >= queries[i][1])
                    break;

                if(notSpecial.get(j) >= queries[i][0]){
                    ans[i] = false;
                    break;
                }
            }
        }

        return ans;
    }
}
*/

//CHATGPT

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        int n = nums.length;

        int[] prefix = new int[n];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1];

            if(nums[i] % 2 == nums[i-1] % 2) {
                prefix[i]++;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            ans[i] = (prefix[r] - prefix[l] == 0);
        }

        return ans;
    }
}
