class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double minAvg = Double.MAX_VALUE;

        for(int i=0; i<nums.length/2; i++){
            int total = nums[i] + nums[nums.length-1-i];
            double avg = total/2.0;
            minAvg = Math.min(minAvg, avg);
        }

        return minAvg;
    }
}