class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<nums1.length || i<nums2.length; i++){
            if(i < nums1.length){

                min1 = Math.min(min1, nums1[i]);

                if(set.contains(nums1[i])){
                    ans = Math.min(ans, nums1[i]);
                }
                else{
                    set.add(nums1[i]);
                }
            }
            if(i < nums2.length){
                min2 = Math.min(min2, nums2[i]);
                if(set.contains(nums2[i])){
                    ans = Math.min(ans, nums2[i]);
                }
                else{
                    set.add(nums2[i]);
                }
            }
        }

        int num = 0;
        if(min1 < min2){
            num = (min1 * 10) + min2;
        }
        else{
            num = (min2 * 10) + min1;
        }

        return (ans == Integer.MAX_VALUE)? num : ans;
    }
}