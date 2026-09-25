class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] unavailable = new boolean[baskets.length];
        int unplaced = 0;

        for(int i : fruits){
            boolean placed = false;
            for(int j=0;j<baskets.length;j++){
                if(baskets[j]>=i && unavailable[j]==false){
                    unavailable[j] = true;
                    placed = true;
                    break;
                }
            }
            if(placed==false)
                unplaced++;
        }

        return unplaced;
    }
}