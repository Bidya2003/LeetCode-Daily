class Solution {
    public int twoEggDrop(int n) {
        int ans = 0;
        int x = 1;
        while(n>0){
            n -= x;
            x++;
            ans++;
        }

        return ans;
    }
}