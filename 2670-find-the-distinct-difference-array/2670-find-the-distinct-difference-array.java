class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        int[] ans = new int[nums.length];
        Set<Integer> check = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            check.add(nums[i]);

            if(map.get(nums[i]) == 1){
                map.remove(nums[i]);
            }
            else{
                map.put(nums[i], map.get(nums[i]) - 1);
            }

            ans[i] = check.size() - map.size();
        }

        return ans;
    }
}