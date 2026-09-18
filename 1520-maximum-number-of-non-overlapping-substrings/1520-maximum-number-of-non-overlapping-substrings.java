// class Solution {
//     class Info{
//         int count;
//         int start;
//         int end;
//         Info(int count, int start, int end){
//             this.count = count;
//             this.start = start;
//             this.end = end;
//         }
//     }

//     public List<String> maxNumOfSubstrings(String s) {

//         List<String> ans = new ArrayList<>();

//         Map<Character,Info> map = new HashMap<>();

//         for(int i=0;i<s.length();i++){
//             if(!map.containsKey(s.charAt(i))){
//                 map.put(s.charAt(i), new Info(1,i,i));
//             }
//             else{
//                 int count = map.get(s.charAt(i)).count;
//                 int start = map.get(s.charAt(i)).start;

//                 map.put(s.charAt(i), new Info(count+1,start,i));
//             }
//         }

//         PriorityQueue<Info> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.start,b.start));

//         for(char c : map.keySet()){
//             pq.add(map.get(c));
//         }

//         int lastStartPoint = 0;
//         int lastEndPoint = 0;
//         int lastCount = 0;

//         while(!pq.isEmpty()){
//             Info front = pq.remove();

//             if((front.end - front.start + 1) == front.count){
//                 String str = s.substring(front.start, front.end+1);
//                 ans.add(str);
//                 lastStartPoint = lastEndPoint = front.end+1;
//                 lastCount = 0;
//                 continue;
//             }

//             if(front.start <= lastEndPoint){
//                 lastEndPoint = Math.max(lastEndPoint, front.end);

//                 if((lastEndPoint - lastStartPoint + 1) == (lastCount + front.count)){
//                     String str = s.substring(lastStartPoint, lastEndPoint+1);
//                     ans.add(str);
//                     lastStartPoint = lastEndPoint;
//                     lastCount = 0;
//                 }
//                 else{
//                     lastCount  += front.count;
//                 }
//             }
//         }

//         return ans;

//     }
// }


import java.util.*;

class Solution {

    class Info {
        int count;
        int start;
        int end;

        Info(int count, int start, int end) {
            this.count = count;
            this.start = start;
            this.end = end;
        }
    }

    public List<String> maxNumOfSubstrings(String s) {

        List<String> ans = new ArrayList<>();

        Map<Character, Info> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, new Info(1, i, i));
            }
            else {
                Info info = map.get(ch);
                info.count++;
                info.end = i;
            }
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.end, b.end)
        );

        for (char c : map.keySet()) {

            Info front = map.get(c);

            int start = front.start;
            int end = front.end;

            boolean valid = true;

            for (int i = start; i <= end; i++) {

                Info inside = map.get(s.charAt(i));

                // Character's first occurrence is outside the interval
                if (inside.start < start) {
                    valid = false;
                    break;
                }

                // Character's last occurrence extends the interval
                end = Math.max(end, inside.end);
            }

            if (valid) {
                pq.add(new Info(0, start, end));
            }
        }

        int lastEnd = -1;

        while (!pq.isEmpty()) {

            Info front = pq.remove();

            if (front.start > lastEnd) {
                ans.add(s.substring(front.start, front.end + 1));
                lastEnd = front.end;
            }
        }

        return ans;
    }
}
