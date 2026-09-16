class Solution {
    long[] arr;

    public int numberOfSets(int n, int k) {

        arr = new long[n];

        // 0 segments -> 1 way
        for(int i = 0; i < n; i++){
            arr[i] = 1;
        }

        int line = 1;

        while(line <= k){

            long[] temp = new long[n];

            temp[0] = 0;

            long sum = 0;

            for(int i = 1; i < n; i++){

                sum = (sum + arr[i - 1]) % 1000000007;

                temp[i] = (temp[i - 1] + sum) % 1000000007;
            }

            arr = temp;
            line++;
        }

        return (int)arr[n - 1];
    }
}