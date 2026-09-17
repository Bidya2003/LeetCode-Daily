class Solution {
    public int singleNumber(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i : nums){
        //     map.put(i, map.getOrDefault(i,0)+1);
        // }

        // for(int key : map.keySet()){
        //     if(map.get(key) == 1){
        //         return key;
        //     }
        // }

        // return -1;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i+=2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}