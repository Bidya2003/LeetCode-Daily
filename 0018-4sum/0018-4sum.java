class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int a=0; a<nums.length; a++){
            if(a != 0 && nums[a] == nums[a-1]){
                continue;
            }
            for(int b=a+1; b<nums.length; b++){
                if(b != a+1 && nums[b] == nums[b-1]){
                    continue;
                }
                for(int c=b+1; c<nums.length; c++){
                    if(c != b+1 && nums[c] == nums[c-1]){
                        continue;
                    }
                    for(int d=c+1; d<nums.length; d++){
                        if(d != c+1 && nums[d] == nums[d-1]){
                            continue;
                        }
                        long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];;

                        //System.out.println(sum);

                        if(sum == (long)target){
                            List<Integer> curr = new ArrayList<>();
                            curr.add(nums[a]);
                            curr.add(nums[b]);
                            curr.add(nums[c]);
                            curr.add(nums[d]);

                            ans.add(curr);
                        }
                    }
                }
            }
        }

        return ans;
    }
}