class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        int width = 0;
        int height = 1;

        long maxArea = -1;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int rec1 = i;
                int rec2 = j;

                int rec1HeightTop = topRight[rec1][height];
                int rec1HeightBase = bottomLeft[rec1][height];

                int rec2HeightTop = topRight[rec2][height];
                int rec2HeightBase = bottomLeft[rec2][height];

                int rec1WidthRight = topRight[rec1][width];
                int rec1WidthLeft = bottomLeft[rec1][width];

                int rec2WidthRight = topRight[rec2][width];
                int rec2WidthLeft = bottomLeft[rec2][width];

                if( rec1HeightTop <= rec2HeightBase || 
                    rec2HeightTop <= rec1HeightBase ||
                    rec1WidthRight <= rec2WidthLeft || 
                    rec2WidthRight <= rec1WidthLeft)
                {
                    continue;
                }

                int overLapHeight = Math.min(rec1HeightTop,rec2HeightTop) - Math.max(rec1HeightBase,rec2HeightBase);
                int overLapWidth = Math.min(rec1WidthRight,rec2WidthRight) - Math.max(rec1WidthLeft,rec2WidthLeft);

                int square = Math.min(overLapHeight, overLapWidth);

                long overLapArea = (long)square * square;

                if(maxArea!=-1)
                    maxArea = Math.max(maxArea,overLapArea);
                else
                    maxArea = overLapArea;

            }
        }

        return (maxArea==-1) ? 0 : maxArea;
    }
}