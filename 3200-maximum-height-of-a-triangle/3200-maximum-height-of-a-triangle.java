// class Solution {
//     public int maxHeightOfTriangle(int red, int blue) {
//         boolean selectRed = true;
//         boolean selectBlue = false;
        
//         int originalRed = red;
//         int originalBlue = blue;

//         red--;

//         int height1 = 1;
//         int n = 1;

//         while(red>0 && blue>0){
//             n++;
//             if(selectRed == true){
//                 blue -= n;
//                 if(blue<0)
//                     break;
//                 selectRed = false;
//                 selectBlue = true;
//             }
//             else{
//                 red -= n;
//                 if(red<0)
//                     break;
//                 selectRed = true;
//                 selectBlue = false;
//             }
//             height1++;
//         }


//         selectRed = false;
//         selectBlue = true;

//         red = originalRed;
//         blue = originalBlue;

//         blue--;

//         int height2 = 1;
//         n = 1;

//         while(red>0 && blue>0){
//             n++;
//             if(selectRed == true){
//                 blue -= n;
//                 if(blue<0)
//                     break;
//                 selectRed = false;
//                 selectBlue = true;
//             }
//             else{
//                 red -= n;
//                 if(red<0)
//                     break;
//                 selectRed = true;
//                 selectBlue = false;
//             }
//             height2++;
//         }

//         return Math.max(height1, height2);
//     }
// }


class Solution { 
    public int maxHeightOfTriangle(int red, int blue) { 

        int originalRed = red;
        int originalBlue = blue;

        boolean selectRed = true; 
        red--; 
 
        int height1 = 1; 
        int n = 1; 
 
        while(true) { 
            n++; 

            if(selectRed == true) { 
                blue -= n; 

                if(blue < 0) 
                    break; 

                selectRed = false; 
            } 
            else { 
                red -= n; 

                if(red < 0) 
                    break; 

                selectRed = true; 
            } 

            height1++; 
        } 

        // Reset
        red = originalRed;
        blue = originalBlue;

        selectRed = false; 
        blue--; 
 
        int height2 = 1; 
        n = 1; 
 
        while(true) { 
            n++; 

            if(selectRed == true) { 
                blue -= n; 

                if(blue < 0) 
                    break; 

                selectRed = false; 
            } 
            else { 
                red -= n; 

                if(red < 0) 
                    break; 

                selectRed = true; 
            } 

            height2++; 
        } 
 
        return Math.max(height1, height2); 
    } 
}