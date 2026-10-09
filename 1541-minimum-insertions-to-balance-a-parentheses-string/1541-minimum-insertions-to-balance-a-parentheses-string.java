class Solution {
    public int minInsertions(String s) {
        int close = 0;
        int ans = 0;
        int idx = 0;

        while(idx < s.length()) {
            if(s.charAt(idx) == '(') {
                if(close % 2 != 0) {
                    ans++;
                    close--;
                }
                close += 2;
            }
            else {
                close--;

                if(close < 0) {
                    ans++;
                    close = 1;
                }
            }

            idx++;
        }

        return ans + close;
    }
}