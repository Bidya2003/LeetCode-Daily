class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;

        long[] score = new long[n];
        Arrays.fill(score,-1);

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            if(parents[i]!=-1){
                graph.get(i).add(parents[i]);
                graph.get(parents[i]).add(i);
                indegree[i]++;
                indegree[parents[i]]++;
            }
        }
        //System.out.println("graph - " + graph);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.add(i);
            }
        }

        long maxScore = -1;

        while(!q.isEmpty()){
            //System.out.println("q - " + q);
            int front = q.remove();
            if(score[front]!= -1)
                continue;

            int remain = 0;
            long nodeScore = 1;
            for(int i : graph.get(front)){
                if(score[i] != -1){
                    nodeScore = nodeScore * indegree[i];
                    remain = remain + indegree[i];
                }
                else{
                    indegree[i]--;
                    if(indegree[i]<2){
                        q.add(i);
                    }
                }
            }
            indegree[front] = remain+1;
            int temp = (n-indegree[front]);

            if(temp != 0)
                score[front] = nodeScore * temp;
            else
                score[front] = nodeScore;
            
            maxScore = Math.max(maxScore,score[front]);
        }
        
        int count = 0;
        for(long i : score){
            if(i==maxScore)
                count++;    
        }

        return count;
    }
}