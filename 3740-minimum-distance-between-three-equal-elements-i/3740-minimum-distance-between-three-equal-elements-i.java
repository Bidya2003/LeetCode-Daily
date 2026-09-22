class Solution {
    public int calculateMinimumDistance(List<Integer> l){
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<l.size(); i++){
            for(int j=i+1; j<l.size(); j++){
                for(int k=j+1; k<l.size(); k++){
                    int curr = Math.abs(l.get(i)-l.get(j)) + Math.abs(l.get(j)-l.get(k)) + Math.abs(l.get(k)-l.get(i));
                    ans = Math.min(ans,curr);
                }
            }
        }

        return ans;
    }
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }
            else{
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        System.out.println(map);

        int ans = Integer.MAX_VALUE;
        for(int key : map.keySet()){
            if(map.get(key).size() >= 3){
                int curr = calculateMinimumDistance(map.get(key));
                ans = Math.min(ans,curr);
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}