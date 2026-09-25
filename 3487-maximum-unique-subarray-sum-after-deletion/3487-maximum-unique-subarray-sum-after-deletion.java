class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i : nums){
            max = Math.max(max,i);
            if(!set.contains(i) && i>0){
                sum += i;
                set.add(i);
            }
        }
        return (sum==0) ? max : sum;
    }
}