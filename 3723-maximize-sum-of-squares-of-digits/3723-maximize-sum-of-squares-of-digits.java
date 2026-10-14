/*
class Solution {
    int maxSquare = 0;
    String ans = "";

    public void checkMaxSumOfSquares(int num, int sum, String curr, int sqr) {
        if(sum == 0 && num == 0){

            if(sqr > maxSquare){
                maxSquare = sqr;
                ans = curr;
            }
            else if(sqr == maxSquare){
                int compare = ans.compareTo(curr);
                if(compare < 0){
                    ans = curr;
                }
            }
        }

        if(num == 0 || sum < 0)
            return;

        for(int i=9; i>=0; i--){
            if(i > sum)
                continue;

            checkMaxSumOfSquares(num-1, sum-i, curr + Integer.toString(i), sqr + (i*i));
        }
    }
    public String maxSumOfSquares(int num, int sum) {
        checkMaxSumOfSquares(num,sum,"",0);

        return ans;
    }
}

*/

class Solution {
    String ans;

    public void checkMaxSumOfSquares(int num, int sum, StringBuilder curr) {

        if(sum == 0 && num == 0){
            ans = curr.toString();
            return;
        }

        if(num == 0 || sum < 0)
            return;

        if(sum > 9 * num)
            return;

        for(int i = 9; i >= 0; i--){

            if(i > sum)
                continue;

            int remainingSum = sum - i;
            int remainingDigits = num - 1;

            if(remainingSum > 9 * remainingDigits)
                continue;

            // choose
            curr.append(i);

            checkMaxSumOfSquares(
                num - 1,
                remainingSum,
                curr
            );

            // backtrack
            curr.deleteCharAt(curr.length() - 1);

            // answer peye gele aar search korbo na
            if(!ans.isEmpty())
                return;
        }
    }

    public String maxSumOfSquares(int num, int sum) {

        ans = "";

        if(sum > 9 * num)
            return "";

        checkMaxSumOfSquares(
            num,
            sum,
            new StringBuilder()
        );

        return ans;
    }
}