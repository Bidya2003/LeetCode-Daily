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