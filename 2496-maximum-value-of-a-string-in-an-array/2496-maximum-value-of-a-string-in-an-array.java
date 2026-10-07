class Solution {
    public int maximumValue(String[] strs) {
        int ans = -1;

        for(int i=0; i<strs.length; i++){
            int curr = -1;
            for(char c : strs[i].toCharArray()){
                if(c-'0' > 9){
                    curr = strs[i].length();
                    break;
                }
            }
            if(curr == -1){
                curr = Integer.parseInt(strs[i]);
            }
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}