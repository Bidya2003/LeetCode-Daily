class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for(String word : words){
            int totalWeight = 0;

            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i)-97;
                totalWeight += weights[idx];
            }

            totalWeight = totalWeight % 26;
            char c = (char)(122 - totalWeight);

            ans.append(c);
        }

        return ans.toString();
    }
}