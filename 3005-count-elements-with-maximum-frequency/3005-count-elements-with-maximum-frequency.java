class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxFreq = -1;
        for(int key : map.keySet()){
            maxFreq = Math.max(maxFreq, map.get(key));
        }

        int sum = 0;
        for(int key : map.keySet()){
            if(map.get(key) == maxFreq)
                sum += maxFreq;
        }

        return sum;
    }
}