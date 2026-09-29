class Solution { 
    public int minimumSubarrayLength(int[] nums, int k) { 
        int ans = Integer.MAX_VALUE; 
 
        for(int i=0; i<nums.length; i++){ 
            int or = nums[i]; 
            
            if(or >= k) 
                ans = Math.min(ans, 1); 
             
            for(int j=i+1; j<nums.length; j++){ 
                or = or | nums[j]; 
                
                if(or >= k) 
                    ans = Math.min(ans, j-i+1); 
            } 
        } 
 
        return ans == Integer.MAX_VALUE ? -1 : ans; 
    } 
}