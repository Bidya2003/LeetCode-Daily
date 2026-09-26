class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        } 

        int last = 0;
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) > 1){
                last = i+1;
                map.put(nums[i], map.get(nums[i])-1);
            }
        }

        System.out.println(last);

        int ans = last / 3;
        if(last % 3 != 0){
            ans++;
        }

        return ans;
    }
}