class Solution {
    int idx = 0;

    public int calculate(String s) {
        int ans = 0;

        while(idx < s.length() && s.charAt(idx) != ')') {

            if(s.charAt(idx) == '(') {
                idx++; // '(' skip

                int inside = calculate(s);

                idx++; // ')' skip

                if(inside == 0)
                    ans += 1;
                else
                    ans += 2 * inside;
            }
        }

        return ans;
    }

    public int scoreOfParentheses(String s) {
        return calculate(s);
    }
}