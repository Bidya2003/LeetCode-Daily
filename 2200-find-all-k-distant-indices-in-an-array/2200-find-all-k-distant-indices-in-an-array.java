class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] == key){
                list.add(i);
            }
        }

        for(int i=0; i<nums.length; i++){
            for(int n : list){
                if(Math.abs(i-n) <= k){
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }
}