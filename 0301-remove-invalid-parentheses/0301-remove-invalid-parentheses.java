class Solution {
    Set<String> ans;
    int total;

    public void checkRemoveInvalidParentheses(String s, String curr, int open, int close, int idx) {
        if(close > open || open > total/2)
            return;
        if(idx == s.length()){
            if(curr.length() == total && open == close){
                ans.add(curr);
                return;
            }
            else
                return;
        }
        checkRemoveInvalidParentheses(s,curr,open,close,idx+1);
        curr = curr + s.charAt(idx);
        if(s.charAt(idx) == '('){
            open++;
        }
        else if(s.charAt(idx) == ')'){
            close++;
        }
        checkRemoveInvalidParentheses(s,curr,open,close,idx+1);
    }
    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();

        int open = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else if(s.charAt(i) == ')'){
                if(open > 0){
                    total += 2;
                    open--;
                }
            }
            else{
                total++;
            }
        }

        //total = (2 * Math.min(open, close)) + others;

        checkRemoveInvalidParentheses(s,"",0,0,0);

        // if(ans.size() == 0){
        //     ans.add("");
        // }

        return new ArrayList<>(ans);
    }
}