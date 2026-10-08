class Solution {
    public String oddString(String[] words) {
        Map<List<Integer>, List<Integer>> set = new HashMap<>();
        String ans = "";

        for(int i=0; i<words.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int c=1; c<words[i].length(); c++){
                list.add(words[i].charAt(c) - words[i].charAt(c-1));
            }

            if(set.containsKey(list)){
                set.get(list).add(i);
            }
            else{
                set.put(list, new ArrayList<>());
                set.get(list).add(i);
            }
        }

        for(List<Integer> key : set.keySet()){
            if(set.get(key).size() == 1){
                return words[set.get(key).get(0)];
            }
        }
        

        return words[0];
    }
}