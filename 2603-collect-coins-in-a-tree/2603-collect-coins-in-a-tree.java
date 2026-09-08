class Solution { 
    public int collectTheCoins(int[] coins, int[][] edges) { 
        
        List<List<Integer>> graph = new ArrayList<>(); 
        
        for(int i = 0; i < coins.length; i++){ 
            graph.add(new ArrayList<>()); 
        } 
        
        for(int i = 0; i < edges.length; i++){ 
            graph.get(edges[i][0]).add(edges[i][1]); 
            graph.get(edges[i][1]).add(edges[i][0]); 
        } 
 
        Queue<Integer> q = new LinkedList<>(); 
        boolean[] visited = new boolean[coins.length]; 
        
        int[] degree = new int[coins.length]; 
        
        for(int i = 0; i < coins.length; i++){ 
            degree[i] = graph.get(i).size(); 
        }


        // ------------------------------------------------
        // PHASE 1:
        // Coin নেই এমন leaf node গুলো remove করবো
        // ------------------------------------------------
        
        for(int i = 0; i < coins.length; i++){ 
            if(degree[i] == 1 && coins[i] == 0){ 
                q.add(i); 
                visited[i] = true; 
            } 
        } 
 
        while(!q.isEmpty()){ 
            
            int front = q.remove(); 
            
            for(int child : graph.get(front)){ 
                
                if(visited[child] == false){ 
                    
                    degree[child]--; 
                    
                    if(degree[child] == 1 && coins[child] == 0){ 
                        q.add(child); 
                        visited[child] = true; 
                    } 
                } 
            } 
            
            degree[front] = 0;
        }


        // ------------------------------------------------
        // PHASE 2:
        // Remaining tree-এর outer 2 layers remove করবো
        // কারণ coin থেকে distance <= 2 হলে coin collect
        // করা যাবে, তাই ওই edges traverse করার দরকার নেই।
        // ------------------------------------------------
        
        q.clear();
        
        for(int i = 0; i < coins.length; i++){ 
            if(degree[i] == 1){ 
                q.add(i); 
            } 
        }


        // Exactly 2 levels remove
        for(int round = 0; round < 2; round++){ 
            
            int size = q.size(); 
            
            for(int i = 0; i < size; i++){ 
                
                int front = q.remove(); 
                
                for(int child : graph.get(front)){ 
                    
                    if(degree[child] > 0){ 
                        
                        degree[child]--; 
                        
                        if(degree[child] == 1){ 
                            q.add(child); 
                        } 
                    } 
                } 
                
                degree[front] = 0;
            } 
        }


        // ------------------------------------------------
        // PHASE 3:
        // Remaining edges প্রতিটা যেতে হবে এবং আবার ফিরে
        // আসতে হবে।
        // ------------------------------------------------
        
        int remainingEdges = 0; 
        
        for(int i = 0; i < coins.length; i++){ 
            remainingEdges += degree[i]; 
        } 
        
        // প্রতিটা edge দুই endpoint-এর degree-তে counted
        remainingEdges /= 2; 
        
        // যাওয়ার জন্য ×2, ফেরার জন্য ×2
        return remainingEdges * 2;
    } 
}

