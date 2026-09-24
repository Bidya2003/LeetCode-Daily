class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();
        for(int i : friends){
            set.add(i);
        }

        int[] ans = new int[friends.length];
        int idx = 0;

        for(int i=0;i<order.length;i++){
            if(set.contains(order[i])){
                ans[idx] = order[i];
                idx++;
            }
        }

        return ans;
    }
}