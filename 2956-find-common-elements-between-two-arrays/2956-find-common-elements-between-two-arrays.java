class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet();
        for(int i : nums1){
            n1.add(i);
        }

        Set<Integer> n2 = new HashSet();
        for(int i : nums2){
            n2.add(i);
        }

        int[] ans = new int[2];

        for(int i=0; i<nums1.length; i++){
            if(n2.contains(nums1[i])){
                ans[0]++;
            }
        }
        for(int i=0; i<nums2.length; i++){
            if(n1.contains(nums2[i])){
                ans[1]++;
            }
        }

        return ans;
    }
}