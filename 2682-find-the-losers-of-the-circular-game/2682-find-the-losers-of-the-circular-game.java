class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] received = new boolean[n];
        int next = 0;
        int steps = 1;

        while(received[next] != true){

            received[next] = true;

            next = (next + (steps * k)) % n;

            steps++;
        }

        int count = 0;

        for(boolean i : received){
            if(i == false)
                count++;
        }

        int[] ans = new int[count];
        int idx = 0;

        for(int i=0 ;i<received.length; i++){
            if(received[i] == false){
                ans[idx] = i+1;
                idx++;
            }
        }

        return ans;
    }
}