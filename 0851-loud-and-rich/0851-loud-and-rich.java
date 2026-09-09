/*
class Solution {
    class Pair{
        int people;
        int quiet;
        Pair(int people, int quiet){
            this.people = people;
            this.quiet = quiet;
        }
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] ans = new int[quiet.length];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<quiet.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<richer.length;i++){
            int a = richer[i][1];
            int b = richer[i][0]; 
            graph.get(a).add(b);
        }

        System.out.println(graph);

        int[] degree = new int[quiet.length];
        for(int i=0;i<quiet.length;i++){
            degree[i] = graph.get(i).size();
        }

        for(int i=0;i<quiet.length;i++){
            Queue<Pair> pq = new LinkedList<>();
            pq.add(new Pair(i,quiet[i]));

            int compare = Integer.MAX_VALUE;
            while(!pq.isEmpty()){
                Pair front = pq.remove();
                if(compare > front.quiet){
                    ans[i] = front.people;
                }

                if(degree[front.people]>0){
                    for(int child : graph.get(front.people)){
                        pq.add(new Pair(child,quiet[child]));
                    }
                }
                compare = quiet[ans[i]];
            }
        }

        return ans;
    }
}
*/


class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] ans = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            ans[i] = i;
        }

        int[] degree = new int[quiet.length];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<quiet.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<richer.length;i++){
            int poor = richer[i][1];
            int rich = richer[i][0]; 
            graph.get(rich).add(poor);
            degree[poor]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<quiet.length;i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }
        

        while(!q.isEmpty()){
            int front = q.remove();

            for(int child : graph.get(front)){
                if(quiet[ans[child]] > quiet[ans[front]]){
                    ans[child] = ans[front];
                }

                degree[child]--;

                if(degree[child]==0){
                    q.add(child);
                }
            }
        }
        return ans;
    }
}