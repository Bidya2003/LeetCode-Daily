class Solution {
    public int averageValue(int[] nums) {
        int n = 0;
        int total = 0;

        for(int i : nums){
            if(i % 2 == 0 && i % 3 == 0){
                total += i;
                n++;
            }
        }

        if( n == 0)
            return 0;

        return total / n;
    }
}