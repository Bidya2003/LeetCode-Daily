class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k == 1)
            return true;
        
        for(int i=0; i<=nums.size()-(2*k); i++){
            int a = i;
            
            for(int j=i; j<i+k-1; j++){
                if(nums.get(j) >= nums.get(j+1)){
                    break;
                }
                else{
                    a = j+1;
                }
            }

            int b = a;

            if(a == i+k-1){
                for(int j=a+1; j<a+k; j++){
                    if(nums.get(j) >= nums.get(j+1)){
                        break;
                    }
                    else{
                        b = j+1;
                    }
                }
            }

            if(b == a+k)
                return true;
        }

        return false;
    }
}