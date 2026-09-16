class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<numRows; i++){
            ans.add(new ArrayList<>());
        }

        ans.get(0).add(1);

        int n = 1;

        while(n < numRows){
            ans.get(n).add(1);
            for(int i=0; i<ans.get(n-1).size()-1; i++){
                int sum = ans.get(n-1).get(i) + ans.get(n-1).get(i+1);
                ans.get(n).add(sum);
            }
            ans.get(n).add(1);

            n++;
        }

        return ans;
    }
}