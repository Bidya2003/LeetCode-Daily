class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }

        int start = nums[0];
        int next = start + 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i]!=next){
                if(start == next-1){
                    String str = Integer.toString(start);
                    ans.add(str);
                }
                else{
                    String str = Integer.toString(start) + "->" + Integer.toString(next-1);
                    ans.add(str);
                }

                start = nums[i];
                next = start+1;
            }
            else{
                next++;
            }
        }

        if(start == next-1){
            String str = Integer.toString(start);
            ans.add(str);
        }
        else{
            String str = Integer.toString(start) + "->" + Integer.toString(next-1);
            ans.add(str);
        }

        return ans;
    }
}