class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        List<Integer> sorted = new ArrayList<>(nums);
        Collections.sort(sorted);
        
        int minIdx = -1;

        for(int i=0; i<nums.size(); i++){
            if(nums.get(i) == sorted.get(0)){
                minIdx = i;
                break;
            }
        }

        //int ans = nums.size()-minIdx;

        int idx = 0;

        while(idx < sorted.size()){
            if(nums.get(minIdx) != sorted.get(idx)){
                return -1;
            }
            idx++;
            minIdx = (minIdx+1) % nums.size();
        }

        if(sorted.get(0) == nums.get(0))
            return 0;

        // for(int i=minIdx; i<nums.size(); i++){
        //     if(nums.get(i) != sorted.get(idx)){
        //         return -1;
        //     }
        //     idx++;
        // }

        return nums.size()-minIdx;
    }
}