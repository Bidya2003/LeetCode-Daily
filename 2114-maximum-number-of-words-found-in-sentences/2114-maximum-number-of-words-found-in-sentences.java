class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = -1;
        for(String str : sentences){
            int word = 0;

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == ' '){
                    word++;
                }
            }

            maxWords = Math.max(maxWords, word+1);
        }

        return maxWords;
    }
}