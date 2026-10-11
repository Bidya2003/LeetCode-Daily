class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer,Integer> occurance = new HashMap<>();

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == key){
                occurance.put(nums[i+1], occurance.getOrDefault(nums[i+1], 0) + 1);
            }
        }

        int max = -1;
        int target = 0;

        for(int k : occurance.keySet()){
            if(max < occurance.get(k)){
                target = k;
                max = occurance.get(k);
            }
        }

        return target;
    }
}