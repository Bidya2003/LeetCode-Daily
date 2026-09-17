class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] minValue = new int[triangle.size()];
        Arrays.fill(minValue, Integer.MAX_VALUE);

        minValue[0] = triangle.get(0).get(0);
        

        for(int i=1; i<triangle.size(); i++){
            // minValue[0] = minValue[0] + triangle.get(i+1).get(0);
            // minValue[1] = minValue[0] + triangle.get(i+1).get(1);
            int carry = minValue[0];

            for(int j=0; j<triangle.get(i).size(); j++){
                //int temp = minValue[j] + triangle.get(i+1).get(j);
                int same = Integer.MAX_VALUE;
                if(j < triangle.get(i-1).size()){
                    same = triangle.get(i).get(j) + minValue[j];
                }

                int next = Integer.MAX_VALUE;
                if(j-1 >= 0){
                    next = triangle.get(i).get(j) + carry;
                }

                carry = minValue[j];

                minValue[j] = Math.min(same,next);

            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i : minValue){
            ans = Math.min(i,ans);
        }

        return ans;
    }
}