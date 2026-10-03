class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.size(); i++){
            int start = nums.get(i).get(0);
            int end = nums.get(i).get(1);

            for(int j=start; j<=end; j++){
                if(!list.contains(j))
                    list.add(j);
            }
        }

        return list.size();
    }
}