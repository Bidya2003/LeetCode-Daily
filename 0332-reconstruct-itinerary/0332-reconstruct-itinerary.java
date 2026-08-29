// class Solution {
//     public List<String> reconstructLexicalOrder(Map<String,List<String>> map, Map<String, Integer> track) {
//         List<String> ans = new ArrayList<>();

//         Queue<String> q = new LinkedList<>();
//         q.add("JFK");
//         track.put("JFK",0);

//         while(!q.isEmpty()){
//             String front = q.remove();
//             System.out.println("front ------  " + front);
//             ans.add(front);
//             System.out.println("ans--- " + ans);

//             List<String> currChild = new ArrayList<>();
//             String large = "ZZZ";
//             if(map.containsKey(front)){
//                 for(String child : map.get(front)){
//                     if(!track.containsKey(front) && track.get(child)==1 && map.containsKey(child)){
//                         currChild.add(child);
//                     }
//                 }
//                 if(currChild.size()==0){
//                     for(String child : map.get(front)){
//                         int compare = large.compareTo(child);
//                         if(compare>0){
//                             large = child;
//                         }
//                     }
//                 }
//                 else if(currChild.size()==1){
//                     large = currChild.get(0);
//                 }
//                 else{
//                     for(int i=0;i<currChild.size();i++){
//                         int compare = large.compareTo(currChild.get(i));
//                         if(compare>0){
//                             large = currChild.get(i);
//                         }
//                     }
//                 }
                
//                 // if(!large.equals("ZZZ")){
//                 //     System.out.println("................................ " + large);
//                 //     q.add(large);
//                 //     System.out.println("q ==== " + q);
//                 //     System.out.println();
//                 //     map.get(front).remove(large);
//                 //     track.put(large, track.get(large)-1);
//                 //     if(track.get(large)==0)
//                 //         track.remove(large);
//                 // }
//             }
//             if(!large.equals("ZZZ")){
//                 q.add(large);
//                 System.out.println("q ==== " + q);
//                 System.out.println();
//                 map.get(front).remove(large);
//                 track.put(large, track.get(large)-1);
//                 if(track.get(large)==0)
//                     track.remove(large);
//             }
//         }
//         return ans;
//     }


class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public void reconstructLexicalOrder(String next) {
        PriorityQueue<String> pq = map.get(next);

        while(pq!=null && !pq.isEmpty()){
            String front = pq.remove();
            reconstructLexicalOrder(front);
        }
        ans.add(0,next);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for(int i=0;i<tickets.size();i++){
            map.putIfAbsent(tickets.get(i).get(0), new PriorityQueue<>());
            map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }
        reconstructLexicalOrder("JFK");

        return ans;
    }
}