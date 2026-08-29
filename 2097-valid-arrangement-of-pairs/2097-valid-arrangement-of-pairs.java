class Solution { 
    List<Integer> ans = new ArrayList<>(); 

    public void reArrangePairs(
            Map<Integer, Queue<Integer>> map, 
            int next) { 

        Queue<Integer> q = map.get(next); 

        while(q != null && !q.isEmpty()){ 

            int front = q.remove(); 

            reArrangePairs(map, front); 

            // recursion-এর পরে এই specific edge add হবে
            ans.add(front); 
            ans.add(next); 
        } 
    } 

    public int[][] validArrangement(int[][] pairs) { 

        Map<Integer, Queue<Integer>> map = new HashMap<>(); 

        Map<Integer, Integer> indegree = new HashMap<>(); 
        Map<Integer, Integer> outdegree = new HashMap<>(); 

        for(int i = 0; i < pairs.length; i++){ 

            map.putIfAbsent(pairs[i][0], new LinkedList<>()); 

            map.get(pairs[i][0]).add(pairs[i][1]); 

            // OUT degree
            outdegree.put(pairs[i][0], outdegree.getOrDefault(pairs[i][0], 0) + 1); 

            // IN degree
            indegree.put(pairs[i][1], indegree.getOrDefault(pairs[i][1], 0) + 1); 
        } 

        boolean get = false; 

        for(int i = 0; i < pairs.length; i++){ 

            int node = pairs[i][0]; 

            if(outdegree.getOrDefault(node, 0) == indegree.getOrDefault(node, 0) + 1){ 

                get = true; 

                reArrangePairs(map, node); 

                break; 
            } 
        } 
         
        if(get == false){ 
            reArrangePairs(map, pairs[0][0]); 
        } 

        int[][] arr = new int[pairs.length][2]; 

        int idx = 0; 
        
        Collections.reverse(ans);

        for(int i = 0; i < arr.length; i++){ 

            arr[i][0] = ans.get(idx); 
            arr[i][1] = ans.get(idx + 1); 

            idx += 2; 
        } 

        return arr; 
    } 
}