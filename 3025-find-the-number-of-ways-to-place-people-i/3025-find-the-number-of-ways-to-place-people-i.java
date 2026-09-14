class Solution { 
    public int numberOfPairs(int[][] points) { 
        
        Arrays.sort(points, (a,b) -> { 
            if(a[0] != b[0]){ 
                return Integer.compare(b[0],a[0]); 
            }
            else{ 
                return Integer.compare(a[1],b[1]); 
            }
        }); 
 
        int count = 0;
        
        for(int i = 0; i < points.length; i++){ 
            
            for(int j = i + 1; j < points.length; j++){ 
                
                if(points[i][0] >= points[j][0] && points[i][1] <= points[j][1]) {
                    
                    boolean valid = true;
                    
                    // i and j er majher sob point check korbo
                    for(int k = i + 1; k < j; k++){
                        
                        if(points[k][1] >= points[i][1] && 
                           points[k][1] <= points[j][1]){
                            
                            valid = false;
                            break;
                        }
                    }
                    
                    if(valid){
                        count++;
                    }
                }
            } 
        } 
 
        return count; 
    } 
}