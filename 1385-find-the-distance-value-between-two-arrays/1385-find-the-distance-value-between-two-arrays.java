class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for(int i : arr1){
            boolean allFalse = false;
            for(int j : arr2){
                if(Math.abs(i - j) <= d){
                    allFalse = true;
                    break;
                }
            }

            if(allFalse == false){
                ans++;
            }
        }

        return ans;
    }
}