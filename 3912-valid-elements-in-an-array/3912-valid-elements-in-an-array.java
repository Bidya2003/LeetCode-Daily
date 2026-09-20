class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        boolean[] valid = new boolean[nums.length];

        // Valid from left
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                valid[i] = true;
                max = nums[i];
            }
        }

        // Valid from right
        max = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > max){
                valid[i] = true;
                max = nums[i];
            }
        }

        // Preserve original order
        for(int i = 0; i < nums.length; i++){
            if(valid[i]){
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}