class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0;
        long total = 0;

        long even = 1;
        long odd = 0;

        for(int i=0; i<arr.length; i++){
            total += arr[i];
            if(total % 2 != 0){
                odd++;
                ans += even;
            }
            else{
                even++;
                ans += odd;
            }
        }
        
        int mod = 1000000007;

        return (int)(ans % mod) ;
    }
}