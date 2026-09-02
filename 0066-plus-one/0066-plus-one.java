class Solution {
    public int[] plusOne(int[] digits) {
        int extra = 1;
        StringBuilder numStr = new StringBuilder();
        for(int i=digits.length-1;i>=0;i--){
            int add = digits[i] + extra;
            extra = add/10;
            int temp = add%10;
            numStr.insert(0,Integer.toString(temp));
        }
        if(extra>0){
            numStr.insert(0,Integer.toString(extra));
        }

        int[] ans = new int[numStr.length()];

        for(int i=0; i<numStr.length();i++){
            ans[i] = numStr.charAt(i)-'0';
        }

        return ans;
    }
}