class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //BOX1
        int plane1 = Math.abs(ax1-ax2);
        int height1 = Math.abs(ay1-ay2);
        int area1 = plane1 * height1;

        //BOX2
        int plane2 = Math.abs(bx1-bx2);
        int height2 = Math.abs(by1-by2);
        int area2 = plane2 * height2;

        //OVERSHADOW

        //overshadow plane
        int largestPlane = Math.max(ax1,bx1);
        int smallestPlane = Math.min(ax2,bx2);
        int overShadowedPlane = 0;
        if(smallestPlane >= largestPlane){
            overShadowedPlane = smallestPlane - largestPlane;
        }

        //overshadow height
        int largestHeight = Math.max(ay1,by1);
        int smallestHeight = Math.min(ay2,by2);
        int overShadowedHeight = 0;
        if(smallestHeight >= largestHeight){
            overShadowedHeight = smallestHeight - largestHeight;
        }

        //overshadow Area
        int overShadowedArea = overShadowedPlane * overShadowedHeight;

        //Actual TOTAL AREA
        int ans = (area1 + area2) - overShadowedArea;

        return ans;
    }
}