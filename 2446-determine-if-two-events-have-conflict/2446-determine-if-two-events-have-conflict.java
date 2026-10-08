class Solution { 
    public boolean haveConflict(String[] event1, String[] event2) { 
        
        // Event 1 -> start
        String start1_h = Character.toString(event1[0].charAt(0)) + Character.toString(event1[0].charAt(1)); 
        int start1_hour = Integer.parseInt(start1_h); 
 
        String start1_m = Character.toString(event1[0].charAt(3)) + Character.toString(event1[0].charAt(4)); 
        int start1_min = Integer.parseInt(start1_m); 

        int start1 = start1_hour * 60 + start1_min;
 
        // Event 1 -> End
        String end1_h = Character.toString(event1[1].charAt(0)) + Character.toString(event1[1].charAt(1)); 
        int end1_hour = Integer.parseInt(end1_h); 
 
        String end1_m = Character.toString(event1[1].charAt(3)) + Character.toString(event1[1].charAt(4)); 
        int end1_min = Integer.parseInt(end1_m); 

        int end1 = end1_hour * 60 + end1_min;
 
        // Event 2 -> start
        String start2_h = Character.toString(event2[0].charAt(0)) + Character.toString(event2[0].charAt(1)); 
        int start2_hour = Integer.parseInt(start2_h); 
 
        String start2_m = Character.toString(event2[0].charAt(3)) + Character.toString(event2[0].charAt(4)); 
        int start2_min = Integer.parseInt(start2_m); 

        int start2 = start2_hour * 60 + start2_min;
 
        // Event 2 -> End
        String end2_h = Character.toString(event2[1].charAt(0)) + Character.toString(event2[1].charAt(1)); 
        int end2_hour = Integer.parseInt(end2_h); 
 
        String end2_m = Character.toString(event2[1].charAt(3)) + Character.toString(event2[1].charAt(4)); 
        int end2_min = Integer.parseInt(end2_m); 

        int end2 = end2_hour * 60 + end2_min;

        // Check conflict
        if(start2 <= end1 && end2 >= start1) {
            return true;
        }

        return false;
    } 
}