class Solution {
    public int titleToNumber(String columnTitle) {

        int n = 0;
        int total = 0;
        while(n<columnTitle.length()){
            char c = columnTitle.charAt(n);
            int num = ((int)c - 64)-1;
            total = (total*26) + num + 1;
            n++;
        }

        return total;
    }
}