class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> exists = new ArrayList<>();

        for(int i=0; i<=nums.length-k; i++){
            for(int j=i; j<i+k; j++){
                if(!exists.contains(nums[j])){
                    map.put(nums[j], map.getOrDefault(nums[j], 0 ) + 1);
                    exists.add(nums[j]);
                }
            }
            exists.clear();
        }

        System.out.println(map);

        int minAppear = Integer.MAX_VALUE;
        int largest = -1;

        for(int key : map.keySet()){
            if(map.get(key) == 1){
                largest = Math.max(largest,key);
            }
        }

        return largest;
    }
}