class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        while(rowIndex>0){
            for(int i=ans.size()-1; i>0; i--){
                int sum = ans.get(i) + ans.get(i-1);
                ans.remove(i);
                ans.add(i,sum);
            }
            ans.add(1);
            rowIndex--;
        }

        return ans;
    }
}