class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a,b) -> Integer.compare(a[0],b[0]));

        int count = 0;
        int maxEnd = -1;

        for(int i=0; i<ranges.length; i++){
            if(ranges[i][0] > maxEnd){
                count++;
                maxEnd = ranges[i][1];
            }
            else{
                maxEnd = Math.max(maxEnd, ranges[i][1]);
            }
        }

        int mod = 1000000007;
        long ans = 1;

        for(int i = 0; i < count; i++) {
            ans = (ans * 2) % mod;
        }

        return (int)ans;
    }
}