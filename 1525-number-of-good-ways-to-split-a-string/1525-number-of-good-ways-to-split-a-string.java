class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();

        int ans = 0;

        for(char c : s.toCharArray()){
            right.put(c, right.getOrDefault(c,0) + 1);
        }

        for(int i=0; i<s.length()-1; i++){
            char c = s.charAt(i);
            left.put(c, left.getOrDefault(c,0) + 1);

            if(right.get(c) == 1){
                right.remove(c);
            }
            else{
                right.put(c, right.get(c) - 1);
            }

            if(left.size() == right.size()){
                ans++;
            }
        }

        return ans;
    }
}