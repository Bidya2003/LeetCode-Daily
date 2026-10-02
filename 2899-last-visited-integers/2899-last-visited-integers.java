class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != -1){
                seen.add(0,nums[i]);
                k = 0;
            }
            else{
                k++;
                if(k>1){
                    int x = (k <= seen.size()) ? seen.get(k-1) : -1;
                    ans.add(x);
                }
                else{
                    int x = (seen.size() > 0) ? seen.get(0) : -1;
                    ans.add(x);
                }
            }
        }

        return ans;
    }
}