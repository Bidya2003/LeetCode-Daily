class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        //List<Integer> even = new ArrayList<>();
        int ans = 0;
        for(int i : nums){
            if(i%2 == 0){
                //even.add(i);
                ans = ans|i;
            }
        }
        // if(even.size()==0)
        //     return 0;

        // int ans = 0;

        // for(int i=0; i<even.size(); i++){
        //     ans = ans|even.get(i);
        // }

        return ans;
    }
}