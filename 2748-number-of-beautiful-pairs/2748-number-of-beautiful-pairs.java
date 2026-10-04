class Solution {
    public int gcd(int x, int y){
        if(y == 0)
            return x;

        return gcd(y, x%y);
    }
    public int countBeautifulPairs(int[] nums) {
        int count = 0;

        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            int first = -1;

            while(x != 0){
                first = x % 10;
                x = x / 10;
            }
            for(int j=i+1; j<nums.length; j++){
                int sec = nums[j] % 10;  

                if(gcd(first,sec) == 1)
                    count++;
            }
        }

        return count;
    }
}