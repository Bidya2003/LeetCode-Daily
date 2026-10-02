class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        int idx = -1;

        for(int i=nums.size()-1; i>=0; i--){
            if(set.contains(nums.get(i)) || nums.get(i)>k){
                continue;
            }
            idx = i;
            set.add(nums.get(i));
        }

        return (nums.size()-idx);
    }
}