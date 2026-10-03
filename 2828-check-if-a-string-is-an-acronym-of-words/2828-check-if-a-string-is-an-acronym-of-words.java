class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size() != s.length())
            return false;

        int idx = 0;

        for(int i=0; i<words.size(); i++){
            if(words.get(i).charAt(0) != s.charAt(idx))
                return false;
            idx++;
        }

        return true;
    }
}