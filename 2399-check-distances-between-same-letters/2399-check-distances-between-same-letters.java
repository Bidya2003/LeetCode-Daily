class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }

        for(char c : map.keySet()){
            int num = c-'a';

            int diff = map.get(c).get(1) - map.get(c).get(0) - 1;

            if(distance[num] != diff)
                return false;
        }

        return true;
    }
}