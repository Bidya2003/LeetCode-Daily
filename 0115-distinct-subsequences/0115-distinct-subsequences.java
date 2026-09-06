/*
class Solution {
    public int findAllSubSequences(String s, String t, int indexT, int indexS, int[][] dp) {
        if(indexT == t.length())
            return 1;
        if(indexS == s.length())
            return 0;

        if(dp[indexT][indexS] != -1)
            return dp[indexT][indexS];

        int count = 0;
        for(int i=indexS;i<s.length();i++){
            if(s.charAt(i) == t.charAt(indexT)){
                count += findAllSubSequences(s,t,indexT+1,i+1,dp);
            }
        }
        return dp[indexT][indexS] = count;
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()][s.length()];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return findAllSubSequences(s,t,0,0,dp);
    }
}
*/


class Solution {

    public int solve(String s, String t, int i, int j, int[][] dp) {

        if (i == t.length()) return 1;
        if (j == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = solve(s, t, i, j + 1, dp);   // skip

        if (s.charAt(j) == t.charAt(i)) {
            ans += solve(s, t, i + 1, j + 1, dp); // take
        }

        return dp[i][j] = ans;
    }

    public int numDistinct(String s, String t) {

        if (t.length() > s.length()) return 0;

        int[][] dp = new int[t.length()][s.length()];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(s, t, 0, 0, dp);
    }
}