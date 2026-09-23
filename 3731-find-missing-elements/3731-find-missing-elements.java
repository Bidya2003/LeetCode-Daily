class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans =new ArrayList<>();
        Arrays.sort(nums);

        if(nums[nums.length-1] - nums[0] == nums.length-1){
            return ans;
        }

        int num = nums[0];

        for(int i=1; i<nums.length; i++){
            num = num+1;
            while(num != nums[i]){
                ans.add(num);
                num++;
            }
        }

        return ans;
    }
}