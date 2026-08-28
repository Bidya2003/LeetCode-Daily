class Solution {
    public List<Integer> courseSerial(List<List<Integer>> graph, int[] intake){
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<intake.length;i++){
            if(intake[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int front = q.remove();
            ans.add(front);
            for(int ele : graph.get(front)){
                intake[ele]--;
                if(intake[ele]==0) q.add(ele);
            }
        }
        return ans;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] intake = new int[numCourses];
        Arrays.fill(intake,0);
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            intake[prerequisites[i][0]]++;
        }

        List<Integer> ans = courseSerial(graph,intake);
        if(ans.size() != numCourses) return new int[0];

        int[] ansArr = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}