class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        List<Integer> greater = new ArrayList<>();
        double max = Double.MIN_VALUE;

        for(int i=0; i<dimensions.length; i++){
            double len = Math.sqrt(dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1]);

            if(max < len){
                greater.clear();
                max = len;
                greater.add(i);
            }
            else if(max == len){
                greater.add(i);
            }
        }

        int maxArea = -1;

        for(int i=0 ;i<greater.size(); i++){
            int mul = dimensions[greater.get(i)][0] * dimensions[greater.get(i)][1];
            maxArea = Math.max(maxArea, mul);
        }      

        return maxArea;
    }
}