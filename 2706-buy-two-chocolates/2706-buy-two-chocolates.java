class Solution {
    public int buyChoco(int[] prices, int money) {
        int retrn = -1;

        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                int p = prices[i] + prices[j];
                
                if(p <= money)
                    retrn = Math.max(retrn, money - p);
            }
        }

        return (retrn == -1)? money : retrn;
    }
}