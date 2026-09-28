class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor = -1;

        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            if(set.contains(i)){
                if(xor==-1)
                    xor = i;
                else{
                    xor = xor ^ i;
                }
            }
            else
                set.add(i);
        }

        return (xor==-1) ? 0 : xor;
    }
}