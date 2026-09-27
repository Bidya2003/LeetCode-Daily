// class Solution { 
//     public int minimumSumSubarray(List<Integer> nums, int l, int r) { 
//         int left = 0; 
//         int right = 0; 
//         int sum = 0; 
//         int minSum = Integer.MAX_VALUE; 
 
//         while(right <= nums.size()){ 
            
//             if(right < nums.size() && (right-left+1) < l){ 
//                 sum += nums.get(right); 
//                 right++; 
//             } 
//             else if(right < nums.size() && (right-left+1) <= r && (right-left+1) >= l){ 
//                 sum += nums.get(right); 
                
//                 if(sum > 0) 
//                     minSum = Math.min(minSum, sum); 
                    
//                 right++; 
//             } 
//             else if(right < nums.size() && (right-left+1) > r){ 
//                 while((right-left+1) > l){
//                     sum -= nums.get(left); 
//                     if(sum > 0) 
//                         minSum = Math.min(minSum, sum); 
//                     left++; 
//                 } 
//             }
//             else { 
//                 if(right == nums.size() && (right-1-left) < l)
//                     break;

//                 while((right-1-left) >= l){
//                     sum -= nums.get(left); 
//                     if(sum > 0) 
//                         minSum = Math.min(minSum, sum); 
//                     left++; 
//                 }
//             }

//         } 
 
//         return (minSum == Integer.MAX_VALUE) ? -1 : minSum;  
//     } 
// }


class Solution {  
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {  
        int left = 0;  
        int right = 0;  
        int sum = 0;  
        int minSum = Integer.MAX_VALUE;  
  
        while(left < nums.size()) {  
            right = left;  
            sum = 0;
  
            while(right < nums.size() && (right-left+1) <= r) {  
                sum += nums.get(right);  
                
                if((right-left+1) >= l && sum > 0) {  
                    minSum = Math.min(minSum, sum);  
                }  
                
                right++;  
            }  
            
            left++;  
        }  
  
        return (minSum == Integer.MAX_VALUE) ? -1 : minSum;   
    }  
}