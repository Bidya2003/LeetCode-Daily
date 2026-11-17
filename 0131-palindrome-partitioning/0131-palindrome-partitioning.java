class Solution {
    boolean[][] isPalindrome;
    List<List<String>> ans;

    public void checkAll(String s, List<String> list, int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            if(isPalindrome[idx][i]){
                list.add(s.substring(idx,i+1));
                checkAll(s, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();

        isPalindrome = new boolean[n][n];

        for(int i=0; i<n; i++){
            isPalindrome[i][i] = true;
        }

        for(int len=2; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i+len-1;
                
                if(s.charAt(i) == s.charAt(j)){
                    if(len == 2 || isPalindrome[i+1][j-1]){
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        ans = new ArrayList<>();

        checkAll(s, new ArrayList<>(), 0);

        return ans;
    }
}