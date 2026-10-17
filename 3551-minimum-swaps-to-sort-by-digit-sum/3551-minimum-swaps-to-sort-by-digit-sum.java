class Solution {
    public int minSwaps(int[] nums) {
        int[] digitSum = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            int sum = 0;

            while(n != 0){
                sum += (n%10);
                n = n / 10;
            }

            digitSum[i] = sum;
        }

        Integer[] index = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            index[i] = i;
        }

        Arrays.sort(index, (a,b) -> {
            if(digitSum[a] != digitSum[b]){
                return Integer.compare(digitSum[a], digitSum[b]);
            }
            else{
                return Integer.compare(nums[a],nums[b]);
            }
        });

        boolean[] visited = new boolean[nums.length];
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(visited[i] == false)
                count++;

            int j = i;

            while(!visited[j]){
                visited[j] = true;
                j = index[j];
            }
        }

        return nums.length - count;
    }
}