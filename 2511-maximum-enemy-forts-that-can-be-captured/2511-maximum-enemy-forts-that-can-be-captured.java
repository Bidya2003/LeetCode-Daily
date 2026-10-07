class Solution {
    public int captureForts(int[] forts) {
        int idx = 0;
        int ans = 0;

        int army = -1; int nofort = -1;

        while(idx < forts.length){
            if(forts[idx] == 1){
                army = idx;
                if(nofort != -1){
                    ans = Math.max(ans, Math.abs(nofort-army)-1);
                    nofort = -1;
                }
            }
            else if(forts[idx] == -1){
                nofort = idx;
                if(army != -1){
                    ans = Math.max(ans, Math.abs(nofort-army)-1);
                    army = -1;
                }
            }
            idx++;
        }

        return ans;
    }
}