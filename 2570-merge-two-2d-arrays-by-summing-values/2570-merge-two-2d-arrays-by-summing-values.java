class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] arr : nums2){
            map.put(arr[0], arr[1]);
        }

        //List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i][0], map.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
            // list.add(new ArrayList<>());
            // list.get(i).add(nums1[i][0]);
            // if(map.containsKey(nums1[i][0])){
            //     list.get(i).add(nums1[i][1] + map.get(nums1[i][0]));
            //     map.remove(nums1[i][0]);
            // }
            // else{
            //     list.get(i).add(nums1[i][1]);
            // }
        }

        // int idx = nums1.length;

        // if(!map.isEmpty()){
        //     for(int key : map.keySet()){
        //         list.add(new ArrayList<>());
        //         list.get(idx).add(key);
        //         list.get(idx).add(map.get(key));
        //         idx++;
        //     }
            
        // }

        int[][] ans = new int[map.size()][2];
        int idx = 0;

        for(int key : map.keySet()){
            ans[idx][0] = key;
            ans[idx][1] = map.get(key);
            idx++;
        }
        // Collections.sort(list, (a,b) -> Integer.compare(a.get(0), b.get(0)));

        // for(int i=0; i<list.size(); i++){
        //     ans[i][0] = list.get(i).get(0);
        //     ans[i][1] = list.get(i).get(1);
        // }

        Arrays.sort(ans, (a,b) -> Integer.compare(a[0], b[0]));

        return ans;
    }
}