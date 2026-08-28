// class Solution {
//     public void allPrerequisite(List<Set<Integer>> graph, List<List<Integer>> childOf, int parent, int child){
//         if(childOf.get(parent).size()==0) return;
//         for(int ele : childOf.get(parent)){
//             graph.get(ele).add(child);
//             allPrerequisite(graph,childOf,ele,child);
//         }
//     }
//     public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
//         List<List<Integer>> childOf = new ArrayList<>();
//         for(int i=0;i<numCourses;i++){
//             childOf.add(new ArrayList<>());
//         }
//         for(int i=0;i<prerequisites.length;i++){
//             childOf.get(prerequisites[i][1]).add(prerequisites[i][0]);
//         }

//         List<Set<Integer>> graph = new ArrayList<>();
//         for(int i=0;i<numCourses;i++){
//             graph.add(new HashSet<>());
//         }
//         for(int i=0;i<prerequisites.length;i++){
//             graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
//             allPrerequisite(graph,childOf,prerequisites[i][0],prerequisites[i][1]);
//         }

//         List<Boolean> ans = new ArrayList<>();
//         for(int i=0;i<queries.length;i++){
//             ans.add(graph.get(queries[i][0]).contains(queries[i][1]));
//         }

//         return ans;
//     }
// }




class Solution {
    public void allPrerequisite(int next, List<List<Integer>> graph, boolean[] visited, boolean[] requisites){
        for(int ele : graph.get(next)){
            if(!visited[ele]){
                visited[ele] = true;
                requisites[ele] = true;
                allPrerequisite(ele,graph,visited,requisites);
            }
        }
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[][] requisites = new boolean[numCourses][numCourses];
        for(int i=0;i<numCourses;i++){
            boolean[] visited = new boolean[numCourses];
            allPrerequisite(i,graph,visited,requisites[i]);
        }

        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            ans.add(requisites[queries[i][0]][queries[i][1]]);
        }

        return ans;
    }
}