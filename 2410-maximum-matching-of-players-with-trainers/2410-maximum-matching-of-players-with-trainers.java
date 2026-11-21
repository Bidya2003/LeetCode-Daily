class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int p = players.length - 1;
        int t = trainers.length - 1;

        int ans = 0;

        while(p>=0 && t>=0){
            if(players[p] <= trainers[t]){
                t--;
                ans++;
            }
            p--;
        }

        return ans;
    }
}