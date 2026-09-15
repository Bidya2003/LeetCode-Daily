/*
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        boolean rightTouchCircle = xCenter + radius >= x1 && xCenter + radius <= x2;
        boolean leftTouchCircle = xCenter - radius >= x1 && xCenter - radius <= x2;

        boolean upperTouchCircle = yCenter - radius >= y1 && yCenter - radius <= y2;
        boolean bottomTouchCircle = yCenter + radius >= y1 && yCenter + radius <= y2;

        if( (rightTouchCircle && upperTouchCircle) ||
            (rightTouchCircle && bottomTouchCircle)||
            (leftTouchCircle && upperTouchCircle)||
            (leftTouchCircle && bottomTouchCircle)){
            return true;
        }

        boolean leftTouchSquare = x1 <= xCenter + radius && x1 >= xCenter - radius;
        boolean rightTouchSquare = x2 >= xCenter - radius && x2 <= xCenter + radius;

        boolean upperTouchSquare = y2 <= yCenter + radius && y2 >= yCenter - radius;
        boolean bottomTouchSquare = y1 <= yCenter + radius && y1 >= yCenter - radius;

        if( (rightTouchSquare && upperTouchSquare) ||
            (rightTouchSquare && bottomTouchSquare)||
            (leftTouchSquare && upperTouchSquare)||
            (leftTouchSquare && bottomTouchSquare)){
            return true;
        }

        return false;
    }
}
*/



class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = Math.max(x1, Math.min(x2,xCenter));
        int closestY = Math.max(y1, Math.min(y2,yCenter));

        int distanceX = xCenter - closestX;
        int distanceY = yCenter - closestY;

        return distanceX*distanceX + distanceY*distanceY <= radius*radius;      
    }
}