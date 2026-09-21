class Solution {
    public int firstUniqueEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        //System.out.println(map.get(2));
        int firstEven = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2==0 && map.get(nums[i])==1){
                firstEven = nums[i];
                break;
            }
        }

        return firstEven;
    }
}