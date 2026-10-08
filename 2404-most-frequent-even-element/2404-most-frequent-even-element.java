class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            if(i % 2 != 0)
                continue;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for(int key : map.keySet()){
            if(max < map.get(key)){
                max = map.get(key);
                ans = key;
            }
            else if(max == map.get(key)){
                ans = Math.min(ans,key);
            }
        }

        return (ans == Integer.MIN_VALUE)? -1 : ans;
    }
}