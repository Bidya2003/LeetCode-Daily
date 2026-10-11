class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> store = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!store.containsKey(nums[i])){
                store.put(nums[i], new ArrayList<>());
            }

            store.get(nums[i]).add(i);
        }

        int count = 0;
        System.out.println(store);

        for(int key : store.keySet()){
            for(int i=0; i<store.get(key).size(); i++){
                for(int j=i+1; j<store.get(key).size(); j++){
                    int mul = store.get(key).get(i) * store.get(key).get(j);
                    if(mul % k == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}