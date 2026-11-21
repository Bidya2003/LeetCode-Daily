class Solution {
    public int[] checkInterval(int[] first, int sec[]){
        if(first[0] > sec[1] || sec[0] > first[1]){
            return new int[0];
        }

        int[] ans = new int[2];

        ans[0] = Math.max(first[0], sec[0]);
        ans[1] = Math.min(first[1], sec[1]);

        return ans;
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        int first = 0;
        int sec = 0;

        while(first < firstList.length && sec < secondList.length){
            int[] ans = checkInterval(firstList[first], secondList[sec]);

            if(ans.length != 0){
                list.add(ans);
            }

            if(firstList[first][1] > secondList[sec][1]){
                sec++;
            }
            else if(firstList[first][1] < secondList[sec][1]){
                first++;
            }
            else{
                first++;
                sec++;
            }
        }

        int[][] res = new int[list.size()][2];

        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}