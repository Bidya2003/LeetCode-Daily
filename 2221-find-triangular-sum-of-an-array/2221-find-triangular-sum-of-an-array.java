class Solution {
    public int triangularSum(int[] nums) {
        StringBuilder str = new StringBuilder();

        for(int i=0; i<nums.length; i++){
            str.append(nums[i]);
        }

        while(str.length() > 1){
            StringBuilder next = new StringBuilder();
            for(int i=0; i<str.length()-1; i++){
                int curr = Integer.parseInt(String.valueOf(str.charAt(i))) + Integer.parseInt(String.valueOf(str.charAt(i+1)));
                next.append(curr%10);
            }

            str = next;
        }

        return Integer.parseInt(String.valueOf(str.charAt(0)));
    }
}