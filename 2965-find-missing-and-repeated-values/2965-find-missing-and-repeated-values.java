class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> set =  new HashSet<>();
        int[] ans = new int[2];

        for(int[] arr : grid){
            for(int i=0; i<arr.length; i++){
                if(set.contains(arr[i])){
                    ans[0] = arr[i];
                    continue;
                }
                else{
                    set.add(arr[i]);
                }
            }
        }

        for(int i=1; i<=n*n; i++){
            if(!set.contains(i)){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}