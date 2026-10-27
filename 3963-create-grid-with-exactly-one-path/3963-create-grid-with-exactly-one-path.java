class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];

        for(int i=0; i<m-1; i++){
            String curr = ".";
            for(int j=1; j<n; j++){
                curr = curr + "#";
            }
            ans[i] = curr;
        }

        String curr = "";
        for(int j=0; j<n; j++){
            curr = curr + ".";
        }
        //curr = curr + ".";

        ans[m-1] = curr;

        return ans;
    }
}