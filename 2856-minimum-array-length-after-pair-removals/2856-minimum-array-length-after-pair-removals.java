class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        for(int key : map.keySet()){
            pq.add(map.get(key));
        }

        while(pq.size() > 1){
            int first = pq.remove();
            int sec = pq.remove();

            first--;
            sec--;
            
            if(first != 0){
                pq.add(first);
            }
            if(sec != 0){
                pq.add(sec);
            }
        }

        return (pq.size() == 0)? 0: pq.remove();
    }
}