class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums1){
            set.add(n);
        }

        List<Integer> ans = new ArrayList<>();

        for(int n : nums2){
            if(set.contains(n) && !ans.contains(n)){
                ans.add(n);
            }
        }

        int[] res = new int[ans.size()];

        for(int i=0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }

        return res;
    }
}