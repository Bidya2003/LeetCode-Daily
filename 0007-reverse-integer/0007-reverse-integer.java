class Solution {
    public int reverse(int x) {
        long range = 2147483648L;

        long rev = 0;

        int num = x;
        while(num!=0){
            int mod = (num%10);
            rev = rev*10 + mod;
            num = num/10;
        }
        

        // if(x<0){
        //     System.out.println("true");
        //     rev = 0-rev;
        //     System.out.println(rev);
        // }

        if(rev>range || -rev>range)
            return 0;

        return (int)rev;
    }
}