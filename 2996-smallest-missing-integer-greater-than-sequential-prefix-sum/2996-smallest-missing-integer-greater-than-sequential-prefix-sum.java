class Solution { 
    public int missingInteger(int[] nums) { 
        int start = 0; 
        int end = 0; 

        int right = 1; 
        int max = nums[0]; 

        while(right < nums.length){ 
            max = Math.max(max, nums[right]);

            if(nums[right] != nums[right-1] + 1){ 
                break;
            }

            end = right;
            right++; 
        } 

        int sum = 0; 
        for(int i=start; i<=end; i++){ 
            sum += nums[i]; 
        } 

        int ans = sum;

        while(true){
            boolean found = false;

            for(int i=0; i<nums.length; i++){
                if(nums[i] == ans){
                    found = true;
                    break;
                }
            }

            if(!found)
                return ans;

            ans++;
        }
    } 
}