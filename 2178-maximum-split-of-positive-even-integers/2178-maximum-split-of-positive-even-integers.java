class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();

        if(finalSum%2 != 0)
            return ans;

        long num = 2;
        while(finalSum > 0){
            long remain = finalSum - num;
            if(remain-num >= 2){
                ans.add(num);
                finalSum = remain;
            }
            else{
                ans.add(finalSum);
                finalSum = 0;
            }
            num+=2;
        }
        return ans;
    }
}