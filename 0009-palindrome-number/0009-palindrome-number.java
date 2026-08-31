class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        
        int rev = 0;
        int num = x;

        while(num!=0){
            int mod = num%10;
            rev = rev*10 + mod;
            num = num/10;
        }

        if(rev==x)
            return true;
        
        return false;
        
    }
}