class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for(int i=nums.length-1; i>=0; i--){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                k--;
            }
            if(k==0)
                break;
        }

        int[] ans = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}