class Solution {
    public int maxDepth(String s) {
        int max = Integer.MIN_VALUE;

        int openBrac = 0;

        for(int i=0;i<s.length(); i++){
            if(s.charAt(i) == '('){
                openBrac++;
                max = Math.max(max, openBrac);
            }
            else if(s.charAt(i) == ')'){
                openBrac--;
            }
        }

        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}