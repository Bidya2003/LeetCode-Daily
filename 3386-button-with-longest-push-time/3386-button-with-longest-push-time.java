class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int index = events[0][0];
        int longestTime = events[0][1];

        for(int i=1;i<events.length;i++){
            if(longestTime < events[i][1]-events[i-1][1]){
                longestTime = events[i][1]-events[i-1][1];
                index = events[i][0];
            }
            else if(longestTime == events[i][1]-events[i-1][1]){
                index = Math.min(index, events[i][0]);
            }
        }

        return index;
    }
}