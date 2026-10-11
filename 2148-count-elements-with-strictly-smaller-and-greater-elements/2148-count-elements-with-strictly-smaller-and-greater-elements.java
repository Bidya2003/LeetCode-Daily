class Solution {
    public int countElements(int[] nums) {
        int cut = 1;

        Arrays.sort(nums);

        int idx = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                idx = i;
                break;
            }
            else{
                cut++;
            }
        }

        if(idx == 0){
            return 0;
        }
        else{
            cut++;
        }

        for(int i=nums.length-2; i>=idx; i--){
            if(nums[i] != nums[i+1]){
                break;
            }
            else{
                cut++;
            }
        }

        return nums.length-cut;
    }
}