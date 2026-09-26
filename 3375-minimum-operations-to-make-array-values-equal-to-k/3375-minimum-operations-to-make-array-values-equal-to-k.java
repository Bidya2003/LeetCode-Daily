class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < k)
                return -1;
            else if(nums[i] > k){
                if(!set.contains(nums[i])){
                    count++;
                    set.add(nums[i]);
                }
            }
        }

        return count;
    }
}