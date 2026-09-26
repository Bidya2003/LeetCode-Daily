class Solution {
    Map<String, String> map;

    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();

        map = new HashMap<>();
        for(int i=0; i<knowledge.size(); i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        int idx = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == '('){
                idx++;
                StringBuilder curr = new StringBuilder();
                while(s.charAt(idx) != ')'){
                    curr.append(s.charAt(idx));
                    idx++;
                }

                if(map.containsKey(curr.toString())){
                    String val = map.get(curr.toString());
                    ans.append(val);
                }
                else{
                    ans.append("?");
                }
            }
            else{
                ans.append(s.charAt(idx));
            }
            idx++;
        }

        return ans.toString();
    }
}