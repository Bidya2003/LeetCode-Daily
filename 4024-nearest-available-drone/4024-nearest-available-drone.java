class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<drones.length; i++){
            int dist1 = Math.abs(drones[i][0] - target[0]);
            int dist2 = Math.abs(drones[i][1] - target[1]);
            if(dist1+dist2 <= drones[i][2]){
                if(min > dist1+dist2){
                    min = dist1+dist2;
                    index = i;
                }
            }
        }

        return index;
    }
}