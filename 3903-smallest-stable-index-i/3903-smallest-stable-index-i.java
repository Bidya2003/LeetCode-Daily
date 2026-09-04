class Solution {
    public int firstStableIndex(int[] nums, int k) {
        Map<Integer,Integer> maximum = new HashMap<>();
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            largest = Math.max(largest,nums[i]);
            maximum.put(i,largest);
        }

        Map<Integer,Integer> minimum = new HashMap<>();
        int smallest = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            smallest = Math.min(smallest,nums[i]);
            minimum.put(i,smallest);
        }
        
        for(int i=0;i<nums.length;i++){
            int a = maximum.get(i);
            int b = minimum.get(i);

            if((a-b)<=k)
                return i;
        }

        return -1;
    }
}