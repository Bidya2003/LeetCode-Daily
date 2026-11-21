class Solution {
    public String largestMerge(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int s1 = 0;
        int s2 = 0;

        StringBuilder ans = new StringBuilder();

        while(s1 < n && s2 < m){
            char large = (word1.substring(s1,n).compareToIgnoreCase(word2.substring(s2,m)) < 0)? 'b' : 'a';

            if(large == 'b'){
                ans.append(word2.charAt(s2));
                s2++;
            }
            else{
                ans.append(word1.charAt(s1));
                s1++;
            }
        }

        if(s1 < n){
            ans.append(word1.substring(s1,n));
        }
        else if(s2 < m){
            ans.append(word2.substring(s2,m));
        }

        return ans.toString();
    }
}