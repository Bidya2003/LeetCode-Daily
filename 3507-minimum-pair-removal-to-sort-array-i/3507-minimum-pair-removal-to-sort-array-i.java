class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            list.add(num);
        }

        int count = 0;

        while(list.size() > 1){

            // already non-decreasing kina check
            boolean sorted = true;
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) < list.get(i - 1)){
                    sorted = false;
                    break;
                }
            }

            if(sorted) break;

            // minimum adjacent pair ber korbo
            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            for(int i = 0; i < list.size() - 1; i++){
                int sum = list.get(i) + list.get(i + 1);

                if(sum < minSum){
                    minSum = sum;
                    idx = i;
                }
            }

            // oi pair merge
            list.set(idx, minSum);
            list.remove(idx + 1);

            count++;
        }

        return count;
    }
}