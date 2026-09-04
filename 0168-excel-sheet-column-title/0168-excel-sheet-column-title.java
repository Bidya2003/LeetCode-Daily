class Solution {
    public String convertToTitle(int columnNumber) {
        String[] sheet = {"", "A", "B", "C" , "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V" ,"W", "X", "Y", "Z"};

        StringBuilder ans = new StringBuilder();
        while(columnNumber>26){
            columnNumber--;

            int rem = columnNumber%26;

            ans.insert(0,sheet[rem+1]);

            columnNumber = columnNumber/26;
        }

        ans.insert(0,sheet[columnNumber]);

        return ans.toString();
    }
}