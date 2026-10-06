class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<nums.length; i++){
            int n = nums[i];

            while(n != 0){
                stack.push(n % 10);
                n = n/10;
            }

            while(!stack.isEmpty()){
                list.add(stack.pop());
            }
        }

        int[] ans = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}