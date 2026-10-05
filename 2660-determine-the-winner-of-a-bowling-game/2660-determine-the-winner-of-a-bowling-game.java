class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int totalP1 = 0;
        int totalP2 = 0;

        int check1 = -1;
        int check2 = -1;

        for(int i=0; i<player1.length; i++){
            //Player 1
            if(i <= check1){
                totalP1 += 2 * player1[i];
            }
            else{
                totalP1 += player1[i];
            }

            if(player1[i] >= 10)
                check1 = i+2;

            //Player 2
            if(i <= check2){
                totalP2 += 2 * player2[i];
            }
            else{
                totalP2 += player2[i];
            }

            if(player2[i] >= 10)
                check2 = i+2;
        }

        if(totalP1 > totalP2)
            return 1;
        else if(totalP1 < totalP2)
            return 2;

        return 0;
    }
}