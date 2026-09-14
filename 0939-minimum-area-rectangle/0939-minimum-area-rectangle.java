class Solution {
    public int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<points.length; i++){
            set.add(40001 * points[i][0] + points[i][1]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[i][0] != points[j][0] && points[i][1] != points[j][1]){
                    if( set.contains(40001 * points[i][0] + points[j][1]) && 
                        set.contains(40001 * points[j][0] + points[i][1]))
                    {
                        ans = Math.min( ans, 
                                        Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                    }
                }
            }
        }

        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}