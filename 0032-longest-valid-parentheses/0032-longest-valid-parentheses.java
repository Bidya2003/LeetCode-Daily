//TIME LIMIT EXCEEDED (233/235 PASSED)

/*
class Solution {
    public int longestValidParentheses(String s) {
        int longest = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')')
                continue;

            int open = 0;
            int close = 0;

            for(int j=i; j<s.length(); j++){
                if(s.charAt(j) == '(')
                    open++;
                else
                    close++;

                if(open == close){
                    longest = Math.max(longest, j-i+1);
                }
                else if(close > open)
                    break;
            }
        }

        return longest;
    }
}
*/


class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int longest = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();

                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    longest = Math.max(longest, i-stack.peek());
                }
            }
        }

        return longest;
    }
}