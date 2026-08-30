class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int maxIdx = 0;
        int minIdx = 0;

        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            if(max==nums[i])
                maxIdx = i;

            min = Math.min(min,nums[i]);
            if(min == nums[i])
                minIdx = i;
        }

        System.out.println("max " + max + " min " + min);

        int remove = 0;

        // if((nums.length-minIdx)<(minIdx+1)){
        //     if((nums.length-maxIdx)<(maxIdx+1)){
        //         remove = Math.max((nums.length-minIdx),(nums.length-maxIdx));
        //     }
        //     else if((nums.length-maxIdx)>(maxIdx+1)){
        //         remove = (nums.length-minIdx) + (maxIdx+1);
        //     }
        //     else{
        //         remove = maxIdx+1;
        //     }
        // }
        // else if((nums.length-minIdx)>(minIdx+1)){
        //     if((nums.length-maxIdx)>(maxIdx+1)){
        //         remove = Math.max((minIdx+1),(maxIdx+1));
        //     }
        //     else if((nums.length-maxIdx)<(maxIdx+1)){
        //         remove = (nums.length-maxIdx) + (minIdx+1);
        //     }
        //     else{
        //         remove = maxIdx+1;
        //     }
        // }
        // else{
        //     if((nums.length-maxIdx)>(maxIdx+1)){
        //         remove = Math.max((minIdx+1),(maxIdx+1));
        //     }
        //     else if((nums.length-maxIdx)<(maxIdx+1)){
        //         remove = (nums.length-maxIdx) + (minIdx+1);
        //     }
        //     else{
        //         remove = minIdx+1;
        //     }
        // }

        if(maxIdx>minIdx){
            int temp1 = (nums.length-maxIdx) + (minIdx+1);
            int temp2 = maxIdx+1;
            int temp3 = nums.length-minIdx;

            remove = Math.min(temp1, Math.min(temp2,temp3));
        }
        else if(maxIdx<minIdx){
            int temp1 = (nums.length-minIdx) + (maxIdx+1);
            int temp2 = minIdx+1;
            int temp3 = nums.length-maxIdx;

            remove = Math.min(temp1, Math.min(temp2,temp3));
        }
        else{
            remove = maxIdx+1;
        }

        return remove;
    }
}