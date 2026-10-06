class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;

        while(k>0){
            Arrays.sort(gifts);
            gifts[gifts.length-1] = (int)Math.sqrt(gifts[gifts.length-1]);
            k--;
        }

        for(int i : gifts){
            ans += (long)i;
        }
        return ans;
    }
}