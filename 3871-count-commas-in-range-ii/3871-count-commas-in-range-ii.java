class Solution {
    public long countCommas(long n) {
        int commas = 0;
        long commaCount = 0;
        long everyThreeDigitStart = 1;
        while(true){
            long everyThreeDigitEnd = everyThreeDigitStart * 1000;
            if(n >= everyThreeDigitEnd-1){
                long temp = (everyThreeDigitEnd-1) - (everyThreeDigitStart-1);
                commaCount += (temp*commas);
            }
            else{
                long temp = n - (everyThreeDigitStart-1);
                commaCount += (temp*commas);
                return commaCount;
            }
            commas++;
            everyThreeDigitStart = everyThreeDigitEnd;
        }
    }
}