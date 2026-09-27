class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int idx = 0;

        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            if(set.contains(i)){
                ans[idx] = i;
                idx++;
            }
            else{
                set.add(i);
            }
        }

        return ans;
    }
}