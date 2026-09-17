class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i= 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i],temp);
            }
        }

        for(int keys : map.keySet()){
            if(map.get(keys).size() > 1){
                for(int idx=0; idx < map.get(keys).size()-1; idx++){
                    if(map.get(keys).get(idx+1) - map.get(keys).get(idx) <= k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}