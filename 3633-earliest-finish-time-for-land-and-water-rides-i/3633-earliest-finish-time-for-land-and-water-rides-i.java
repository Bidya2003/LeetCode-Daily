class Solution {
    public int checkAllFinishTime(int[] startTime, int[] duration, int start) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<startTime.length; i++){
            if(startTime[i] <= start){
                min = Math.min(min,duration[i]);
            }
            else{
                min = Math.min(min, (startTime[i] - start + duration[i]));
            }
        }
        return min;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<landStartTime.length; i++){
            int curr = landStartTime[i]+landDuration[i];
            int t = checkAllFinishTime(waterStartTime,waterDuration,curr);
            ans = Math.min(ans, curr+t);
        }

        for(int i=0; i<waterStartTime.length; i++){
            int curr = waterStartTime[i]+waterDuration[i];
            int t = checkAllFinishTime(landStartTime,landDuration,curr);
            ans = Math.min(ans, curr+t);
        }

        return ans;
    }
}