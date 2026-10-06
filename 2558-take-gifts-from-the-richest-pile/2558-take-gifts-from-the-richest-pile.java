class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i : gifts){
            pq.add(i);
        }

        while(k>0){
            int front = (int)Math.sqrt(pq.remove());
            pq.add(front);
            k--;
        }

        long ans = 0;

        while(!pq.isEmpty()){
            ans += (long)pq.remove();
        }
        return ans;
    }
}