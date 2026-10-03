class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();

        for(int i=0; i<words.size(); i++){
            int idx = 0;
            StringBuilder str = new StringBuilder();
            while(idx < words.get(i).length()){
                if(words.get(i).charAt(idx) == separator){
                    if(str.length() != 0){
                        ans.add(str.toString());
                        str.delete(0,str.length());
                    }
                }
                else{
                    str.append(words.get(i).charAt(idx));
                }
                idx++;
            }
            if(str.length() != 0){
                ans.add(str.toString());
            }
        }

        return ans;
    }
}