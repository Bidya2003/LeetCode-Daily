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
    public int findAllSubSequences(String s, String t, int indexT, int indexS, int[][] dp) {
        if(indexT == t.length())
            return 1;
        if(indexS == s.length())
            return 0;

        if(dp[indexT][indexS] != -1)
            return dp[indexT][indexS];

        int count = findAllSubSequences(s,t,indexT,indexS+1,dp);
        if(s.charAt(indexS) == t.charAt(indexT)){
            count += findAllSubSequences(s,t,indexT+1,indexS+1,dp);
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
