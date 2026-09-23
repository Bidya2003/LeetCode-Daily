class Solution {
    public int earliestTime(int[][] tasks) {
        int minTime = Integer.MAX_VALUE;

        for(int i=0;i<tasks.length;i++){
            minTime = Math.min(minTime, tasks[i][0]+tasks[i][1]);
        }

        return minTime;
    }
}