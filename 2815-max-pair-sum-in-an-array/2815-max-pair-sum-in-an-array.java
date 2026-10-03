class Solution {
    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            int max = -1;

            while(n != 0){
                max = Math.max(max, n%10);
                n = n / 10;
            }

            if(!map.containsKey(max)){
                map.put(max, new ArrayList<>());
                map.get(max).add(nums[i]);
            }
            else{
                map.get(max).add(nums[i]);
            }
        }

        //int max = -1;
        int maxSum = -1;

        for(int key : map.keySet()){
            if(map.get(key).size() > 1){
                Collections.sort(map.get(key));
                int sum = map.get(key).get(map.get(key).size()-1) + map.get(key).get(map.get(key).size()-2);

                maxSum = Math.max(maxSum, sum);
            }
        }

        // System.out.println(map);

        // if(max == -1)
        //     return -1;
        

        // Collections.sort(map.get(max));
        // int sum = map.get(max).get(map.get(max).size()-1) + map.get(max).get(map.get(max).size()-2);
        
        return maxSum;
    }
}