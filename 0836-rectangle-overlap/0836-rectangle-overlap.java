class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // if((rec1[0]<rec2[0] && rec1[2]>rec2[0] && rec1[1]<rec2[1] && rec1[3]>rec2[1]) || (rec1[0]<rec2[2] && rec1[2]>rec2[2] && rec1[1]<rec2[3] && rec1[3]>rec2[3])){
        //     return true;
        // }

        int rec1Top = Math.max(rec1[0],rec1[2]);
        int rec2Top = Math.max(rec2[0],rec2[2]);

        int rec1Down = Math.min(rec1[0],rec1[2]);
        int rec2down = Math.min(rec2[0],rec2[2]);

        int rec1Right = Math.max(rec1[1],rec1[3]);
        int rec2Right = Math.max(rec2[1],rec2[3]);

        int rec1Left= Math.min(rec1[1],rec1[3]);
        int rec2Left = Math.min(rec2[1],rec2[3]);

        if((rec1Top <= rec2down) || (rec1Down >= rec2Top) || (rec1Right <= rec2Left) || (rec1Left >= rec2Right)){
            return false;
        }
        return true;
    }
}