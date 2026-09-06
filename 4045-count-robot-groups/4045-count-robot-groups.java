class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int pos1 = Integer.MAX_VALUE;
        int speed1 = Integer.MAX_VALUE;

        int len = speed.length;
        int count = 0;

        for(int i=len-1;i>=0;i--){
            int pos2 = position[i];
            int speed2 = speed[i];

            if(pos1-pos2 > distance && speed2<=speed1){
                count++;
                speed1 = speed2;
            }
            pos1 = pos2;
        }

        return count;
    }
}