class Solution {
    class Pair{
        int height;
        int idx;
        Pair(int height, int idx){
            this.height = height;
            this.idx = idx;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.height, a.height));

        for(int i=0; i<heights.length; i++){
            pq.add(new Pair(heights[i],i));
        }

        String[] ans = new String[names.length];
        int index = 0;

        while(!pq.isEmpty()){
            int i = pq.remove().idx;
            ans[index] = names[i];
            index++;
        }

        return ans;
    }
}