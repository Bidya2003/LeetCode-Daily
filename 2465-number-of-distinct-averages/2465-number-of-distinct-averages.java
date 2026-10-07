class Solution {
    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length/2; i++){
            double avg = (nums[i] + nums[nums.length-1-i]) / 2.0;
            set.add(avg);
        }

        return set.size();
    }
}