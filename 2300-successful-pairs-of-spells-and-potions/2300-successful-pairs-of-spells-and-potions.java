/*
//Time Limit Exceeded (51 / 57 testcases passed)

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;

        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int num = spells[i];

            int pair = 0;

            for(int p : potions){
                long mul = (long)p * num;

                if(mul >= success){
                    pair++;
                }
            }

            ans[i] = pair;
        }

        return ans;
    }
}
*/


class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        Integer[] sortIdx = new Integer[n];

        for(int i=0; i<n; i++){
            sortIdx[i] = i;
        }

        Arrays.sort(sortIdx, (a,b) -> Integer.compare(spells[a], spells[b]));
        Arrays.sort(potions);

        int[] ans = new int[n];

        int s = n-1;
        int p = 0;

        while(s >= 0 && p < m){
            long mul = (long)spells[sortIdx[s]] * potions[p];
            
            if(mul >= success){
                ans[sortIdx[s]] = m - p;
                s--;
            }
            else{
                p++;
            }
        }

        return ans;
    }
}