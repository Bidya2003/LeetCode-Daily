class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();

        int open = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }
            if(open > 1){
                ans.append(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                open--;
            }
        }

        return ans.toString();
    }
}