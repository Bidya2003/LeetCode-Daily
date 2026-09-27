class Solution {
    int idx = 0;

    public String reverseSubstringParentheses(String s) {
        String str = "";

        while(idx < s.length() && s.charAt(idx) != ')') {

            if(s.charAt(idx) == '(') {
                idx++;

                String next = reverseSubstringParentheses(s);

                String rev = "";
                for(int i = next.length() - 1; i >= 0; i--) {
                    rev += next.charAt(i);
                }

                str += rev;
            }
            else {
                str += s.charAt(idx);
            }

            idx++;
        }

        return str;
    }

    public String reverseParentheses(String s) {
        idx = 0;
        return reverseSubstringParentheses(s);
    }
}