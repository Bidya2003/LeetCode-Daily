class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                list.add(i);
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i : list){
            ans = Math.min(ans, Math.abs(startIndex - i));

            if(startIndex > i){
                int temp = i + (words.length-startIndex);
                ans = Math.min(ans, temp);
            }
            else if(startIndex < i){
                int temp = startIndex + (words.length-i);
                ans = Math.min(ans, temp);
            }
        }

        return (ans == Integer.MAX_VALUE)? -1 : ans;
    }
}