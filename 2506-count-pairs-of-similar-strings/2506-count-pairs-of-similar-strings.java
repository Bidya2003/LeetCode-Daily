class Solution {
    public int similarPairs(String[] words) {
        int count = 0;

        for(int i=0; i<words.length; i++){
            Set<Character> set1 = new HashSet<>();

            for(char c : words[i].toCharArray()){
                set1.add(c);
            }

            for(int j=i+1; j<words.length; j++){
                Set<Character> set2 = new HashSet<>();

                for(char c : words[j].toCharArray()){
                    set2.add(c);
                }

                boolean valid = true;

                for(char c : set1){
                    if(!set2.contains(c)){
                        valid = false;
                        break;
                    }
                    else{
                        set2.remove(c);
                    }
                }

                if(valid && set2.size() == 0){
                    count++;
                }
            }
        }

        return count;
    }
}