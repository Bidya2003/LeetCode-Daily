class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        for(int i=0; i<nums.length; i++){
            ans[0] = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(map.get(nums[i]) != map.get(nums[j])){
                    ans[1] = nums[j];
                    return ans;
                }
            }
            ans[0] = -1;
        }

        return ans;
    }
}